package com.gientech.pcm.wealth;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cjm
 * @date 2023/7/7 19:22
 */
@Slf4j
@Service
@Transactional
public class PcmWealthService extends BaseService<PcmWealthMapper, PcmWealth> {
    /**
     * 新增--保存
     *
     * @param dto
     */
    public void saveWealth(PcmWealthDTO4Save dto){
        log.info("新增对私理财："+ dto);

        PcmWealth pcmWealth = new PcmWealth();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmWealth);
//        if(isExistWealthId(pcmWealth.getWealthId())){
//            throw new AppException("新增失败，wealthId："+pcmWealth.getWealthId()+"已经存在！！");
//        }
        this.save(pcmWealth);
    }

    /**
     * 删除--多个id以逗号分隔
     *
     * @param wealthIds
     */
    public void deleteWealth(String wealthIds){
        log.info("删除对私理财："+wealthIds);

        String[] wealthIdArray = StrUtil.splitToArray(wealthIds,",");
        for(String wealthId:wealthIdArray){
            this.removeById(wealthId);
        }
    }

    /**
     * 修改
     *
     * @param dto
     */
    public void updateWealth(PcmWealthDTO4Update dto){
        log.info("修改对私理财："+dto.getWealthId());

        PcmWealth pcmWealth = new PcmWealth();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmWealth);

        if(!this.updateById(pcmWealth)){
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }
    /**
     * 查询和分页
     *
     * @param dto
     *
     * @return
     */
    public DataGrid<PcmWealthVO> listWealth(PcmWealthDTO4List dto){
        log.info("查询--对私理财" + dto);
        //处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(),dto.getOrder(),"a.WEALTH_ID asc"));
        //构造分页函数
        Page<PcmWealthVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<PcmWealthVO>(this.getBaseMapper().getPcmWealthList(page, dto), page.getTotal());


    }





    //判断wealthId是否已经存在
//    private boolean isExistWealthId(String wealthId){
//        return this.getById(wealthId) != null;
//    }
}