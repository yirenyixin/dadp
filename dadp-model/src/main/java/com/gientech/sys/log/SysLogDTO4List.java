package com.gientech.sys.log;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【登录日志】SysLog查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "登录日志--查询条件的DTO类")
public class SysLogDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前页码", required = true, position = 1)
	@NotNull(message = "[pageNo]当前页码，不能为空")
	@Min(value = 1, message = "[pageNo]当前页码，不能小于1")
	@Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
	private Integer pageNo;// 当前页码

	@ApiModelProperty(value = "每页大小", required = true, position = 2)
	@NotNull(message = "[pageSize]每页大小，不能为空")
	@Min(value = 1, message = "[pageSize]每页大小，不能小于1")
	@Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
	private Integer pageSize;// 每页大小

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "用户ID", position = 14)
	private String userId;// 用户ID

	@ApiModelProperty(value = "用户姓名", position = 15)
	private String userName;// 用户姓名

	@ApiModelProperty(value = "日志内容", position = 16)
	private String logInfo;// 日志内容

	@ApiModelProperty(value = "IP地址", position = 17)
	private String ipAddr;// IP地址

	// -----------------分割线---------------------------------------

}