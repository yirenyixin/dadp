package com.gientech.sys.operLog;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 【操作日志】SysOperLog查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "操作日志--查询条件的DTO类")
public class SysOperLogDTO4List implements Serializable {

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

	@ApiModelProperty(value = "开始日期", example = "2020-01-01", dataType = "java.lang.String", position = 11)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dateFrom;// 开始日期

	@ApiModelProperty(value = "结束日期", example = "2020-01-01", dataType = "java.lang.String", position = 12)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dateTo;// 结束日期

	@ApiModelProperty(value = "日志ID", position = 13)
	private String operLogId;// 日志ID

	@ApiModelProperty(value = "模块名称", position = 14)
	private String moduleName;// 模块名称

	@ApiModelProperty(value = "操作类型", position = 15)
	private String operType;// 操作类型

	@ApiModelProperty(value = "操作来源", position = 16)
	private String operSource;// 操作来源

	@ApiModelProperty(value = "用户ID", position = 17)
	private String userId;// 用户ID

	@ApiModelProperty(value = "机构ID", position = 18)
	private String orgId;// 机构ID

	@ApiModelProperty(value = "请求URL", position = 19)
	private String reqUrl;// 请求URL

	@ApiModelProperty(value = "方法名称", position = 20)
	private String reqMethod;// 方法名称

	@ApiModelProperty(value = "请求方式", position = 21)
	private String reqMode;// 请求方式

	@ApiModelProperty(value = "IP地址", position = 22)
	private String ipAddr;// IP地址

	@ApiModelProperty(value = "请求参数", position = 23)
	private String reqParam;// 请求参数

	@ApiModelProperty(value = "返回结果", position = 24)
	private String result;// 返回结果

	@ApiModelProperty(value = "是否操作成功", position = 25)
	private String isOk;// 是否操作成功

	// -----------------分割线---------------------------------------

}