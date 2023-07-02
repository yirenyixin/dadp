package com.gientech.sys.book;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.sys.cache.SysCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 图书管理 - Service
 */
@Slf4j
@Service
@Transactional
public class SysBookService extends BaseService<SysBookMapper, SysBook> {

    @Autowired
    private SysCacheService sysCacheService;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<SysBookVO> listBooks(SysBookDTO4List dto) {
        log.info("【list查询条件--图书】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "bookName,author,publisher");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.CREATE_TIME desc"));

        // 构造分页参数
        Page<SysBookVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getSysBookList(page, dto), page.getTotal());
    }

    /**
     * 新增图书
     *
     * @param dto 新增DTO
     */
    public void saveBook(SysBookDTO4Save dto) {
        log.info("【新增--图书】" + dto);

        // 从dto中复制属性
        SysBook sysBook = new SysBook();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysBook);

        // 校验图书ID是否存在
        if (isExistBookId(sysBook.getBookId())) {
            throw new AppException("新增失败，图书ID【" + sysBook.getBookId() + "】已经存在！");
        }

        this.save(sysBook);
        sysCacheService.loadBookToRedis();
    }

    /**
     * 修改图书
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updateBook(SysBookDTO4Update dto) {
        log.info("【修改--图书】" + dto);

        // 从dto中复制属性
        SysBook sysBook = new SysBook();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysBook);

        // 更新图书信息
        if (!this.updateById(sysBook)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
        sysCacheService.loadBookToRedis();
    }

    /**
     * 删除图书
     *
     * @param bookIds 多个图书ID以逗号分隔
     */
    public void deleteBook(String bookIds) {
        log.info("【删除--图书】" + bookIds);

        // 删除图书
        String[] bookIdArray = StrUtil.splitToArray(bookIds, ",");
        for (String bookId : bookIdArray) {
            this.removeById(bookId);
        }
        sysCacheService.loadBookToRedis();
    }

    /**
     * 检查图书ID是否存在
     *
     * @param bookId 图书ID
     * @return 是否存在
     */
    private boolean isExistBookId(String bookId) {
        return this.getById(bookId) != null;
    }
}