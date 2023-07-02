package com.gientech.sys.bookState;

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
 * 图书状态管理 - Service
 */
@Slf4j
@Service
@Transactional
public class SysBookStateService extends BaseService<SysBookStateMapper, SysBookState> {

    @Autowired
    private SysCacheService sysCacheService;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<SysBookStateVO> listBookStates(SysBookStateDTO4List dto) {
        log.info("【list查询条件--图书状态】" + dto);

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.Book_ID desc"));

        // 构造分页参数
        Page<SysBookStateVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getSysBookStateList(page, dto), page.getTotal());
    }

    /**
     * 获取图书状态
     *
     * @param bookStateId 图书状态ID
     * @return 图书状态VO
     */
    public SysBookStateVO getBookState(String bookStateId) {
        log.info("【查询--图书状态】" + bookStateId);

        return this.getBaseMapper().getBookState(bookStateId);
    }

    /**
     * 新增图书状态
     *
     * @param dto 新增DTO
     */
    public void saveBookState(SysBookStateDTO4Save dto) {
        log.info("【新增--图书状态】" + dto);

        // 从dto中复制属性
        SysBookState sysBookState = new SysBookState();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysBookState);

        // 校验图书状态ID是否存在
        if (isExistBookStateId(sysBookState.getBookId())) {
            throw new AppException("新增失败，图书状态ID【" + sysBookState.getBookId() + "】已经存在！");
        }

        this.save(sysBookState);
        sysCacheService.loadBookStateToRedis();
    }

    /**
     * 修改图书状态
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updateBookState(SysBookStateDTO4Update dto) {
        log.info("【修改--图书状态】" + dto);

        // 从dto中复制属性
        SysBookState sysBookState = new SysBookState();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysBookState);

        // 更新图书状态信息
        if (!this.updateById(sysBookState)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
        sysCacheService.loadBookStateToRedis();
    }

    /**
     * 删除图书状态
     *
     * @param bookStateIds 多个图书状态ID以逗号分隔
     */
    public void deleteBookState(String bookStateIds) {
        log.info("【删除--图书状态】" + bookStateIds);

        // 删除图书状态
        String[] bookStateIdArray = StrUtil.splitToArray(bookStateIds, ",");
        for (String bookStateId : bookStateIdArray) {
            this.removeById(bookStateId);
        }
        sysCacheService.loadBookStateToRedis();
    }

    /**
     * 检查图书状态ID是否存在
     *
     * @param bookStateId 图书状态ID
     * @return 是否存在
     */
    private boolean isExistBookStateId(String bookStateId) {
        return this.getById(bookStateId) != null;
    }
}
