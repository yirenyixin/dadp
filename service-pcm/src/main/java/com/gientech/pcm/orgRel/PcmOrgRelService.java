package com.gientech.pcm.orgRel;


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
 * 机构归属关系--Service
 *
 * @author 吴俊达
 */
@Slf4j
@Service
@Transactional
public class PcmOrgRelService extends BaseService<PcmOrgRelMapper, PcmOrgRel> {
    /**
     * 【1】新增--保存
     *
     * @param dto
     */
    public void saveOrgRel(PcmOrgRelDTO4Save dto) {
        log.info("【新增--机构归属关系】" + dto);

        // 【1】 从dto中copy属性
        PcmOrgRel pcmOrgRel = new PcmOrgRel();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmOrgRel);

        // 【2】 校验id是否存在
        if (isExistOrgRelId(pcmOrgRel.getOrgRelId())) {
            throw new AppException("新增失败，机构归属关系ID【" + pcmOrgRel.getOrgRelId() + "】已经存在！");
        }

        this.save(pcmOrgRel);
    }


    /**
     * 【2】删除--多个id以逗号分隔
     *
     * @param orgRelIds
     */
    public void deleteOrgRel(String orgRelIds) {
        log.info("【删除--机构归属关系】" + orgRelIds);

        // 【1】删除
        String[] orgRelIdArray = StrUtil.splitToArray(orgRelIds, ",");
        for (String orgRelId : orgRelIdArray) {
            this.removeById(orgRelId);
        }
    }

    /**
     * 【3】修改
     *
     * @param pcmOrgRel
     */
    public void updateOrgRel(PcmOrgRelDTO4Update dto) {
        log.info("【修改--机构归属关系】" + dto);

        // 【1】 从dto中copy属性
        PcmOrgRel pcmOrgRel = new PcmOrgRel();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmOrgRel);


        if (!this.updateById(pcmOrgRel)) {
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
    public DataGrid<PcmOrgRelVO> listOrgRel(PcmOrgRelDTO4List dto) {
        log.info("【查询条件--机构归属关系】" + dto);
        // 【1】构造分页参数
        Page<PcmOrgRelVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());
        return new DataGrid<PcmOrgRelVO>(this.getBaseMapper().getPcmOrgRelList(page, dto), page.getTotal());
    }



    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

    /**
     * 【21】检查orgRelId是否存在
     *
     * @param orgRelId
     * @return
     */
    private boolean isExistOrgRelId(String orgRelId) {
        return this.getById(orgRelId) != null;
    }
}
