package com.gientech.sys.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class SysLoginDTO4UpdatePassword implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", required = true, position = 1)
    @NotBlank(message = "[userId]用户ID，不能为空")
    private String userId;// 用户ID

    @ApiModelProperty(value = "旧密码", required = true, position = 2)
    @NotBlank(message = "[oldPassword]旧密码，不能为空")
    private String oldPassword;// 旧密码

    @ApiModelProperty(value = "新密码", required = true, position = 3)
    @NotBlank(message = "[newPassword]新密码，不能为空")
    private String newPassword;// 新密码

    @ApiModelProperty(value = "确认新密码", required = true, position = 3)
    @NotBlank(message = "[configNewPassword]确认新密码，不能为空")
    private String configNewPassword;// 确认新密码

}
