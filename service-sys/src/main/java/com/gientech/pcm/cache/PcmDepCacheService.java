package com.gientech.pcm.cache;//package com.gientech.sys.cache;

import com.gientech.common.MyConstants;
import com.gientech.common.view.Combo;
import com.gientech.core.redis.RedisService;
import com.gientech.pcm.depCurr.PcmDepCurr;
import com.gientech.pcm.depCurr.PcmDepCurrService;
import com.gientech.pcm.depFixed.PcmDepFixedService;
import com.gientech.pcm.depFixed.PcmDepFixed;
import com.gientech.pcm.loan.PcmLoan;
import com.gientech.pcm.loan.PcmLoanService;
import com.gientech.pcm.prodOwn.PcmProdOwn;
import com.gientech.pcm.prodOwn.PcmProdOwnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现InitializingBean接口，系统启动的时候将sys模块的部分数据，缓存到redis
 *
 * @author 胡砥峰
 */
@Slf4j
@Component("pcm_depCacheService")
public class PcmDepCacheService implements InitializingBean {

    @Resource
    RedisService redisService;

    @Resource
    PcmDepFixedService pcmDepFixedService;
    @Resource
    PcmDepCurrService pcmDepCurrService;
    @Resource
    PcmLoanService pcmLoanService;
    @Resource
    PcmProdOwnService pcmProdOwnService;
    @Override
    public void afterPropertiesSet() throws Exception {



        loadPcmDepFixedToRedis();//fixed
        loadPcmDepCurrToRedis();//curr
        loadPcmLoanToRedis();//loan
        loadPcmProdOwnToRedis();//prodOwn

    }




    /**
     * 【1】将 PcmDepFixed 信息加载到 Redis
     */
    public void loadPcmDepFixedToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 查询所有 PcmDepFixed 信息
        List<PcmDepFixed> pcmDepFixedList = pcmDepFixedService.list();
        for (PcmDepFixed pcmDepFixed : pcmDepFixedList) {
            comboList.add(new Combo(pcmDepFixed.getDepFixedId(), pcmDepFixed.getCustId(), pcmDepFixed.getCustName()));
            redisService.set(MyConstants.REDIS_DEP_FIXED + pcmDepFixed.getDepFixedId(), pcmDepFixed.getCustId());
        }

        redisService.set(MyConstants.DEP_FIXED_ID, comboList);

        log.info("-------------------【1】PcmDepFixed 信息加载到 Redis 完成-------------------");
    }


    /**
     * 【2】将 PcmDepCurr 信息加载到 Redis
     */
    public void loadPcmDepCurrToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

// 查询所有 PcmDepCurr 信息
        List<PcmDepCurr> pcmDepCurrList = pcmDepCurrService.list();
        for (PcmDepCurr pcmDepCurr : pcmDepCurrList) {
            comboList.add(new Combo(pcmDepCurr.getDepCurrId(), pcmDepCurr.getCustId(), pcmDepCurr.getCustName()));
            redisService.set(MyConstants.REDIS_PCM_DEP_CURR + pcmDepCurr.getDepCurrId(), pcmDepCurr.getCustId());
        }

        redisService.set(MyConstants.PCM_DEP_CURR_ID, comboList);

        log.info("-------------------【2】PcmDepCurr 信息加载到 Redis 完成-------------------");
    }

    /**
     * 【3】将PcmLoan信息加载到Redis
     */
    public void loadPcmLoanToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 查询所有PcmLoan信息
        List<PcmLoan> pcmLoanList = pcmLoanService.list();
        for (PcmLoan pcmLoan : pcmLoanList) {
            comboList.add(new Combo(pcmLoan.getLoanId(), pcmLoan.getCustId(), pcmLoan.getCustName()));
            redisService.set(MyConstants.REDIS_PCM_LOAN + pcmLoan.getLoanId(), pcmLoan.getCustId());
        }

        redisService.set(MyConstants.PCM_LOAN_ID, comboList);

        log.info("-------------------【3】PcmLoan信息加载到Redis完成-------------------");
    }

    /**
     * 【4】将PcmProdOwn信息加载到Redis
     */
    public void loadPcmProdOwnToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 查询所有PcmProdOwn信息
        List<PcmProdOwn> pcmProdOwnList = pcmProdOwnService.list();
        for (PcmProdOwn pcmProdOwn : pcmProdOwnList) {
            comboList.add(new Combo(pcmProdOwn.getProdOwnId(), pcmProdOwn.getCustId(), pcmProdOwn.getLawOrgId()));
            redisService.set(MyConstants.REDIS_PCM_PROD_OWN + pcmProdOwn.getProdOwnId(), pcmProdOwn.getCustId());
        }

        redisService.set(MyConstants.PCM_PROD_OWN_ID, comboList);

        log.info("-------------------【4】PcmProdOwn信息加载到Redis完成-------------------");
    }
}
