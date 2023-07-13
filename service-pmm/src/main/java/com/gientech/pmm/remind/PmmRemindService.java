package com.gientech.pmm.remind;

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
 * @date 2023/7/8 15:03
 */
@Slf4j
@Service
@Transactional
public class PmmRemindService extends BaseService<PmmRemindMapper, PmmRemind> {

    /**
     * 新增--保存
     *
     * @param dto
     */

    public void saveRemind(PmmRemindDTO4Save dto){

        log.info("提醒表--新增");

        PmmRemind pmmRemind = new PmmRemind();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pmmRemind);
//        if(isExistRemind(dto.getRemindId())){
//            throw new AppException("新增失败，remindId："+pmmRemind.getRemindId()+"已经存在！！");
//        }

        this.save(pmmRemind);

    }

    /**
     * 删除--多个id以逗号分隔
     *
     * @param remindIds
     */
    public void deleteRemind(String remindIds){

        log.info("删除提醒表："+remindIds);

        String[] remindIdArray = StrUtil.splitToArray(remindIds,",");
        for(String remindId : remindIdArray){
            this.removeById(remindId);
        }

    }

    /**
     * 修改
     *
     * @param dto
     */
    public void updateRemind(PmmRemindDTO4Update dto){

        log.info("修改提醒表：" + dto);

        PmmRemind pmmRemind = new PmmRemind();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pmmRemind);

        if(!this.updateById(pmmRemind)){
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
    public DataGrid<PmmRemindVO> listRemind(PmmRemindDTO4List dto){

        log.info("查询条件--提醒表：" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "eventType,eventSmallType");

        // 【2】处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.REMIND_ID asc"));
        dto.setReceiverUserId(this.getUserSession().getUserId());

        // 【3】构造分页参数
        Page<PmmRemindVO> page = new Page<>(dto.getPageNo(),dto.getPageSize());

        return new DataGrid<PmmRemindVO>(this.getBaseMapper().getPmmRemindList(page, dto), page.getTotal());

    }




//    private boolean isExistRemind(String remindId){
//        return this.getById(remindId) != null;
//    }


}