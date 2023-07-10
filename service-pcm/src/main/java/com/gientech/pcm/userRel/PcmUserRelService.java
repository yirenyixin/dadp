package com.gientech.pcm.userRel;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户经理归属关系--Service
 *
 * @author 吴俊达
 */
@Slf4j
@Service
@Transactional
public class PcmUserRelService extends BaseService<PcmUserRelMapper, PcmUserRel> {
    /**
     * 【1】新增--保存
     *
     * @param dto
     */
    public void saveUserRel(PcmUserRelDTO4Save dto) {
        log.info("【新增--客户经理归属关系】" + dto);

        // 【1】 从dto中copy属性
        PcmUserRel pcmUserRel = new PcmUserRel();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmUserRel);

        // 【2】 校验id是否存在
        if (isExistUserRelId(pcmUserRel.getUserRelId())) {
            throw new AppException("新增失败，客户经理归属关系ID【" + pcmUserRel.getUserRelId() + "】已经存在！");
        }

        this.save(pcmUserRel);
    }


    /**
     * 【2】删除--多个id以逗号分隔
     *
     * @param userRelIds
     */
    public void deleteUserRel(String userRelIds) {
        log.info("【删除--客户经理归属关系】" + userRelIds);

        // 【1】删除
        String[] userRelIdArray = StrUtil.splitToArray(userRelIds, ",");
        for (String userRelId : userRelIdArray) {
            this.removeById(userRelId);
        }
    }

    /**
     * 【3】修改
     *
     * @param pcmUserRel
     */
    public void updateUserRel(PcmUserRelDTO4Update dto) {
        log.info("【修改--客户经理归属关系】" + dto);

        // 【1】 从dto中copy属性
        PcmUserRel pcmUserRel = new PcmUserRel();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmUserRel);


        if (!this.updateById(pcmUserRel)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 【4】查询和分页
     *
     * @param dto
     *
     * @return
     */
    public DataGrid<PcmUserRelVO> listUserRel(PcmUserRelDTO4List dto) {
        log.info("【查询条件--客户经理归属关系】" + dto);
        // 【1】构造分页参数
        Page<PcmUserRelVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<PcmUserRelVO>(this.getBaseMapper().getPcmUserRelList(page, dto), page.getTotal());
    }



    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

    /**
     * 【21】检查userRelId是否存在
     *
     * @param userRelId
     * @return
     */
    private boolean isExistUserRelId(String userRelId) {
        return this.getById(userRelId) != null;
    }
}
