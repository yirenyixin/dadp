package com.gientech.pmm.remindTemp;

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
 * @date 2023/7/7 22:54
 */
@Slf4j
@Service
@Transactional
public class PmmRemindTempService extends BaseService<PmmRemindTempMapper,PmmRemindTemp> {
    /**
     * 新增--保存
     *
     * @param dto
     */
    public void saveRemindTemp(PmmRemindTempDTO4Save dto){
        log.info("新增事件参数管理："+ dto);

        PmmRemindTemp remindTemp = new PmmRemindTemp();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, remindTemp);

        //阈值。事件大类为产品到期类、周期提醒类和提前提醒类时必填
        if(remindTemp.getEventType().equals("11102")||
                remindTemp.getEventType().equals("11103")||
                remindTemp.getEventType().equals("11104")){
            if(remindTemp.getDayNum()==null){
                throw new AppException("事件大类为产品到期类、周期提醒类和提前提醒类时必填:提前提醒天数!");
            }
        }

        this.save(remindTemp);
    }

    /**
     * 删除--多个id以逗号分隔
     *
     * @param remindTempIds
     */
    public void deleteRemindTemp(String remindTempIds){
        log.info("删除事件参数管理："+remindTempIds);

        String[] remindTempIdArray = StrUtil.splitToArray(remindTempIds,",");
        for(String remindTempId:remindTempIdArray){
            this.removeById(remindTempId);
        }
    }

    /**
     * 修改
     *
     * @param dto
     */
    public void updateReminTemp(PmmRemindTempDTO4Update dto){

        log.info("修改事件参数管理：" + dto);

        PmmRemindTemp pmmRemindTemp = new PmmRemindTemp();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pmmRemindTemp);

        if(!this.updateById(pmmRemindTemp)){
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
    public DataGrid<PmmRemindTempVO> listRemind(PmmRemindTempDTO4List dto){

        log.info("查询条件--时间管理参数：" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "eventType,eventSmallType,isOk");

        // 【2】处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.REMIND_TEMP_ID asc"));

        // 【3】构造分页参数
        Page<PmmRemindTempVO> page = new Page<>(dto.getPageNo(),dto.getPageSize());

        return new DataGrid<PmmRemindTempVO>(this.getBaseMapper().getPmmRemindTempList(page,dto), page.getTotal());

    }



//    private boolean isExistRemindTempId(String remindTempId){
//        return this.getById(remindTempId) != null;
//    }
}