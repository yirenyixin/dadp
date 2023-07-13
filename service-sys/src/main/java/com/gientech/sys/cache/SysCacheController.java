package com.gientech.sys.cache;

import cn.hutool.core.util.StrUtil;
import com.gientech.common.MyConstants;
import com.gientech.common.Result;
import com.gientech.common.enums.OperType;
import com.gientech.common.view.Combo;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.redis.RedisService;
import com.gientech.core.security.annotation.PreAuthorize;
import com.gientech.sys.codeType.SysCodeType;
import com.gientech.sys.codeType.SysCodeTypeService;
import com.gientech.sys.org.SysOrgService;
import com.gientech.sys.user.SysUserService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取下拉框缓存--Controller
 *
 * @author 胡砥峰
 */
@Api(tags = "【1-02】获取缓存")
@ApiSort(value = 102) // 排序号生成后要修改
@RestController
@RequestMapping("/sys/cache")
public class SysCacheController {

    @Resource
    RedisService redisService;

    @Resource
    SysCodeTypeService sysCodeTypeService;

    @Resource
    SysOrgService sysOrgService;

    @Resource
    SysUserService sysUserService;

    /**
     * 【1】获取下拉框列表,传codeTypeId,不传返回全部下拉框。。前段登录后，访问这个请求
     *
     * @param sysCacheDTO
     * @return
     */
    @ApiOperation(value = "获取下拉框列表", notes = "获取下拉框列表,传codeTypeId,多个用逗号分隔,不传返回全部")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "获取下拉框列表", operType = OperType.OTHER)
    @PreAuthorize(hasAuth = MyConstants.IS_LOGIN) // 菜单id或功能id
    @PostMapping("/listCombo")
    public Result<Map<String, List<Combo>>> listCombo(@Valid @RequestBody SysCacheDTO sysCacheDTO, BindingResult bindingResult) {

        HashMap<String, List<Combo>> map = new HashMap<String, List<Combo>>();

        // 【1】不传codeTypeId，获取所有的下拉框
        if (StrUtil.isEmpty(sysCacheDTO.getCodeTypeId())) {
            List<SysCodeType> codeTypeList = this.sysCodeTypeService.list();
            for (SysCodeType sysCodeType : codeTypeList) {
                map.put(sysCodeType.getCodeTypeId(), (List<Combo>) this.redisService.get(MyConstants.REDIS_SYS_CODE_TYPE + sysCodeType.getCodeTypeId()));
            }

            map.put(MyConstants.COMBO_ORG_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_ORG));
            map.put(MyConstants.COMBO_USER_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_USER));
            map.put(MyConstants.COMBO_ROLE_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_ROLE));
        } else {
            // 【2】根据前端参数，获取相应的下拉框
            String[] codeTypeIdArray = StrUtil.splitToArray(sysCacheDTO.getCodeTypeId(), ",");
            for (String codeTypeId : codeTypeIdArray) {
                if (MyConstants.COMBO_ORG_ID.equals(codeTypeId)) {// orgId
                    map.put(MyConstants.COMBO_ORG_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_ORG));

                } else if (MyConstants.COMBO_USER_ID.equals(codeTypeId)) {// userId
                    map.put(MyConstants.COMBO_USER_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_USER));

                } else if (MyConstants.COMBO_ROLE_ID.equals(codeTypeId)) {// roleId
                    map.put(MyConstants.COMBO_ROLE_ID, (List<Combo>) this.redisService.get(MyConstants.REDIS_COMBO_ROLE));

                } else {// 下拉框
                    map.put(codeTypeId, (List<Combo>) this.redisService.get(MyConstants.REDIS_SYS_CODE_TYPE + codeTypeId));

                }
            }
        }

        return Result.success(map);
    }

    /************* 【以上代码是oms后台管理功能,下面代码是app对接功能!】 *********************************************************************************************/
}
