package com.gientech.sys.login;

import com.gientech.common.MyConstants;
import com.gientech.common.Result;
import com.gientech.common.auth.UserSession;
import com.gientech.common.enums.OperType;
import com.gientech.core.base.BaseController;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.security.annotation.PreAuthorize;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 系统登录和退出--Controller
 *
 * @author 胡砥峰
 */
@Api(tags = "【1-01】系统登录相关")
@ApiSort(value = 101) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys")
public class SysLoginController extends BaseController {

    @Autowired
    SysLoginService sysLoginService;

    /**
     * 【1】新系统登录,前段拿到token，写入Bearer Token
     *
     * @author yhc 20220525
     */
    @ApiOperation(value = "系统登录")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "系统登录", operType = OperType.LOGIN)
    @PostMapping("/login")
    public Result<UserSession> login(@Valid @RequestBody SysLoginDTO sysLoginDTO, BindingResult bindingResult) {
        return Result.success(sysLoginService.login(sysLoginDTO));
    }

    /**
     * 【2】新角色切换
     *
     * @author yhc 20220525
     */
    @ApiOperation(value = "角色切换")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "角色切换", operType = OperType.OTHER)
    @PreAuthorize(hasAuth = MyConstants.IS_LOGIN) // 菜单id或功能id
    @PostMapping("/changeRole")
    public Result<UserSession> changeRole(@Valid @RequestBody SysLoginDTO4ChangeRole dto, BindingResult bindingResult) {
        return Result.success(sysLoginService.changeRole(dto.getRoleId()));
    }

    /**
     * 【4】退出登录
     *
     * @return
     */
    @ApiOperation(value = "退出登录")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "退出登录", operType = OperType.OTHER)
    @PreAuthorize(hasAuth = MyConstants.IS_LOGIN) // 菜单id或功能id
    @PostMapping("/logout")
    public Result<Object> logout() {
        return Result.success(sysLoginService.logout());
    }

    /**
     * 【5】修改密码
     *
     * @param dto
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改密码")
    @ApiOperationSupport(order = 5)
    @OperLog(title = "修改密码", operType = OperType.OTHER)
    @PreAuthorize(hasAuth = MyConstants.IS_LOGIN) // 菜单id或功能id
    @PostMapping("/updatePassword")
    public Result<Object> updatePassword(@Valid @RequestBody SysLoginDTO4UpdatePassword dto, BindingResult bindingResult) {
        return Result.success(sysLoginService.updatePassword(dto));
    }
}
