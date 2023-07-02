package com.gientech.sys.operLog;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【操作日志】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysOperLogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "日志ID", position = 1)
	private String operLogId;// 日志ID

	@ApiModelProperty(value = "模块名称", position = 2)
	private String moduleName;// 模块名称

	@ApiModelProperty(value = "操作类型", position = 3)
	private String operType;// 操作类型

	@ApiModelProperty(value = "操作来源", position = 4)
	private String operSource;// 操作来源

	@ApiModelProperty(value = "用户ID", position = 5)
	private String userId;// 用户ID

	@ApiModelProperty(value = "机构ID", position = 6)
	private String orgId;// 机构ID

	@ApiModelProperty(value = "请求URL", position = 7)
	private String reqUrl;// 请求URL

	@ApiModelProperty(value = "方法名称", position = 8)
	private String reqMethod;// 方法名称

	@ApiModelProperty(value = "请求方式", position = 9)
	private String reqMode;// 请求方式

	@ApiModelProperty(value = "IP地址", position = 10)
	private String ipAddr;// IP地址

	@ApiModelProperty(value = "请求参数", position = 11)
	private String reqParam;// 请求参数

	@ApiModelProperty(value = "返回结果", position = 12)
	private String result;// 返回结果

	@ApiModelProperty(value = "是否操作成功", position = 13)
	private String isOk;// 是否操作成功

	@ApiModelProperty(value = "发生时间", example = "2020-01-01 08:30:25", dataType = "java.lang.String", position = 14)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date logTime;// 发生时间

	// -----------------分割线---------------------------------------

}