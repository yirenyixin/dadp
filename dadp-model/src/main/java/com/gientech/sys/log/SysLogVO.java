package com.gientech.sys.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 【登录日志】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysLogVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "日志ID", position = 1)
	private String logId;// 日志ID

	@ApiModelProperty(value = "用户ID", position = 2)
	private String userId;// 用户ID

	@ApiModelProperty(value = "用户姓名", position = 3)
	private String userName;// 用户姓名

	@ApiModelProperty(value = "日志内容", position = 4)
	private String logInfo;// 日志内容

	@ApiModelProperty(value = "IP地址", position = 5)
	private String ipAddr;// IP地址

	@ApiModelProperty(value = "发生时间", example = "2020-01-01 08:30:25", dataType = "java.lang.String", position = 6)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date logTime;// 发生时间

	// -----------------分割线---------------------------------------

}