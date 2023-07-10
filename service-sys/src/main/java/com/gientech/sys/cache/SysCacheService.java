package com.gientech.sys.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.MyConstants;
import com.gientech.common.view.Combo;
import com.gientech.core.redis.RedisService;

import com.gientech.sys.codeInfo.SysCodeInfo;
import com.gientech.sys.codeInfo.SysCodeInfoService;
import com.gientech.sys.codeType.SysCodeType;
import com.gientech.sys.codeType.SysCodeTypeService;
import com.gientech.sys.config.SysConfig;
import com.gientech.sys.config.SysConfigService;
import com.gientech.sys.org.SysOrg;
import com.gientech.sys.org.SysOrgService;
import com.gientech.sys.role.SysRole;
import com.gientech.sys.role.SysRoleService;
import com.gientech.sys.roleData.SysRoleDataService;
import com.gientech.sys.user.SysUser;
import com.gientech.sys.user.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现InitializingBean接口，系统启动的时候将sys模块的部分数据，缓存到redis
 *
 * @author 胡砥峰
 */
@Slf4j
@Component("sysCacheService")
public class SysCacheService implements InitializingBean {

    @Resource
    RedisService redisService;

    @Resource
    SysConfigService sysConfigService;

    @Resource
    SysCodeTypeService sysCodeTypeService;

    @Resource
    SysCodeInfoService sysCodeInfoService;

    @Resource
    SysOrgService sysOrgService;

    @Resource
    SysUserService sysUserService;

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysRoleDataService sysRoleDataService;


    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfigToRedis();
        loadCodeTypeToRedis();
        loadRoleDataToRedis();
        loadOrgMapToRedis();

        loadOrgToRedis();
        loadUserToRedis();
        loadRoleToRedis();




//        loadPcmDepFixedToRedis();
    }



    /**
     * 【1】加载sysConfig到redis
     */
    public void loadConfigToRedis() {
        List<SysConfig> list = sysConfigService.list();

        for (SysConfig sysConfig : list) {
            redisService.set(MyConstants.REDIS_SYS_CONFIG + sysConfig.getConfigId(), sysConfig);
        }

        log.info("-------------------【1】系统参数sysConfig，加载到redis完成-------------------");
    }

    /**
     * 【2】加载sysCodeType到redis
     */
    public void loadCodeTypeToRedis() {

        // 【1】查主表codeType
        List<SysCodeType> codeTypelist = this.sysCodeTypeService.list(null);

        //【2】构造codeInfo
        Map<String, List<Combo>> mapCodeInfo = buildCodeInfo();


        for (SysCodeType sysCodeType : codeTypelist) {
            redisService.set(MyConstants.REDIS_SYS_CODE_TYPE + sysCodeType.getCodeTypeId(), mapCodeInfo.get(sysCodeType.getCodeTypeId()));
        }

        log.info("-------------------【2】代码类别sysCodeType，加载到redis完成-------------------");
    }

    /**
     * 构造codeinfo下拉框
     *
     * @return
     * @ 2022-06-24 wuxiaoyi add
     */
    private Map<String, List<Combo>> buildCodeInfo() {
        // 【1】获取codeInfo
        List<SysCodeInfo> codeInfolist = this.sysCodeInfoService.getAllCodeInfo();
        List<Combo> comboList = new ArrayList<Combo>();
        Map<String, List<Combo>> map = new HashMap<String, List<Combo>>();
        if (codeInfolist == null || codeInfolist.size() < 1) {
            return new HashMap<String, List<Combo>>();
        }
        for (int i = 0; i < codeInfolist.size(); i++) {
            SysCodeInfo codeInfo = codeInfolist.get(i);
            if (map.containsKey(codeInfo.getCodeTypeId())) {
                comboList = map.get(codeInfo.getCodeTypeId());
                comboList.add(new Combo(codeInfo.getValue(), codeInfo.getContent(), codeInfo.getParentValue()));
                map.put(codeInfo.getCodeTypeId(), comboList);

            } else {
                comboList = new ArrayList<Combo>();
                comboList.add(new Combo(null, "请选择", null));
                comboList.add(new Combo(codeInfo.getValue(), codeInfo.getContent(), codeInfo.getParentValue()));
                map.put(codeInfo.getCodeTypeId(), comboList);
            }
        }
        return map;
    }

    /**
     * 【3】加载sysOrg到redis
     */
    public void loadOrgToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 【1】
        List<SysOrg> list = sysOrgService.list();
        for (SysOrg sysOrg : list) {
            comboList.add(new Combo(sysOrg.getOrgId(), sysOrg.getOrgName(), sysOrg.getParentOrgId()));
        }

        redisService.set(MyConstants.REDIS_COMBO_ORG, comboList);

        log.info("-------------------【3】机构sysOrg，加载到redis完成-------------------");
    }

    /**
     * 【4】加载user到redis
     */
    public void loadUserToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 【1】
        List<SysUser> list = sysUserService.list();
        for (SysUser sysUser : list) {
            comboList.add(new Combo(sysUser.getUserId(), sysUser.getUserName(), null));
        }

        redisService.set(MyConstants.REDIS_COMBO_USER, comboList);

        log.info("-------------------【4】用户sysUser，加载到redis完成-------------------");
    }

    /**
     * 【5】加载role到redis
     */
    public void loadRoleToRedis() {
        List<Combo> comboList = new ArrayList<>();
        comboList.add(new Combo(null, "请选择", null));

        // 【1】
        List<SysRole> list = sysRoleService.list();
        for (SysRole sysRole : list) {
            comboList.add(new Combo(sysRole.getRoleId(), sysRole.getRoleName(), null));
            redisService.set(MyConstants.REDIS_SYS_ROLE_INFO + sysRole.getRoleId(), sysRole);
         }

        redisService.set(MyConstants.REDIS_COMBO_ROLE, comboList);

        log.info("-------------------【5】用户sysRole，加载到redis完成-------------------");
    }

    /**
     * 【6】加载roleData数据权限到redis
     */
    public void loadRoleDataToRedis() {
        List<SysRole> list = sysRoleService.list();
        for (SysRole sysRole : list) {
            redisService.set(MyConstants.REDIS_SYS_ROLE + sysRole.getRoleId(), this.sysRoleDataService.getRoleDataListByRoleId(sysRole.getRoleId()));
        }

        log.info("-------------------【6】数据权限SysRoleData，加载到redis完成-------------------");
    }

    /**
     * 【7】读取 机构org , 根据<orgId, SysOrg> 组织成一个 Map， 此方法供 系统启动时候的Listener调用。
     *
     * @return 机构 orgMap<orgId, SysOrg>
     * @author 胡砥峰
     */
    public void loadOrgMapToRedis() {

        Map<String, SysOrg> orgMap = new HashMap<String, SysOrg>();

        // 【1】查出所有机构
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("SORT_NO");
        List<SysOrg> allOrgList = this.sysOrgService.list(queryWrapper);

        for (SysOrg sysOrg : allOrgList) {
            orgMap.put(sysOrg.getOrgId(), sysOrg);
        }

        redisService.set(MyConstants.REDIS_SYS_ORG_MAP, orgMap);
    }





//    /**
//     * 【10】将 PcmDepFixed 信息加载到 Redis
//     */
//    public void loadPcmDepFixedToRedis() {
//        List<Combo> comboList = new ArrayList<>();
//        comboList.add(new Combo(null, "请选择", null));
//
//        // 查询所有 PcmDepFixed 信息
//        List<PcmDepFixed> pcmDepFixedList = pcmDepFixedService.list();
//        for (PcmDepFixed pcmDepFixed : pcmDepFixedList) {
//            comboList.add(new Combo(pcmDepFixed.getDepFixedId(), pcmDepFixed.getCustId(), pcmDepFixed.getCustName()));
//            redisService.set(MyConstants.REDIS_DEP_FIXED + pcmDepFixed.getDepFixedId(), pcmDepFixed.getCustId());
//        }
//
//        redisService.set(MyConstants.DEP_FIXED_ID, comboList);
//
//        log.info("-------------------【10】PcmDepFixed 信息加载到 Redis 完成-------------------");
//    }
}
