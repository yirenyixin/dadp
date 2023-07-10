package com.gientech.ppm.cache;//package com.gientech.ppm.cache;//package com.gientech.sys.cache;
//
//import com.gientech.common.MyConstants;
//import com.gientech.common.view.Combo;
//import com.gientech.core.redis.RedisService;
//import com.gientech.pcm.depCurr.PcmDepCurr;
//import com.gientech.pcm.depCurr.PcmDepCurrService;
//import com.gientech.pcm.depFixed.PcmDepFixed;
//import com.gientech.pcm.depFixed.PcmDepFixedService;
//import com.gientech.pcm.loan.PcmLoan;
//import com.gientech.pcm.loan.PcmLoanService;
//import com.gientech.ppm.prod.PpmProd;
//import com.gientech.ppm.prod.PpmProdService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 实现InitializingBean接口，系统启动的时候将sys模块的部分数据，缓存到redis
// *
// * @author 胡砥峰
// */
//@Slf4j
//@Component("ppm_CacheService")
//public class PpmCacheService implements InitializingBean {
//    @Resource
//    RedisService redisService;
//    @Resource
//    PpmProdService ppmProdService;
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        loadPpmProdToRedis();//prod
//
//    }
//
//    /**
//     * 【2】将 PpmProd 信息加载到 Redis
//     */
//    public void loadPpmProdToRedis() {
//        List<Combo> comboList = new ArrayList<>();
//        comboList.add(new Combo(null, "请选择", null));
//
//        // 查询所有 PpmProd 信息
//        List<PpmProd> ppmProdList = ppmProdService.list();
//        for (PpmProd ppmProd : ppmProdList) {
//            comboList.add(new Combo(ppmProd.getProdId(), ppmProd.getProdName(), null));
//            redisService.set(MyConstants.REDIS_PPM_PROD + ppmProd.getProdId(), ppmProd.getProdName());
//        }
//
//        redisService.set(MyConstants.PPM_PROD_ID, comboList);
//
//        log.info("-------------------【2】PpmProd 信息加载到 Redis 完成-------------------");
//    }
//
//}
