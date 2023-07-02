package com.gientech.sys.operLog;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 操作日志实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_OPER_LOG")
public class SysOperLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "OPER_LOG_ID", type = IdType.ASSIGN_ID)
	private String operLogId;// 日志ID

	@TableField(value = "MODULE_NAME")
	private String moduleName;// 模块名称

	@TableField(value = "OPER_TYPE")
	private String operType;// 操作类型

	@TableField(value = "OPER_SOURCE")
	private String operSource;// 操作来源

	@TableField(value = "USER_ID")
	private String userId;// 用户ID

	@TableField(value = "ORG_ID")
	private String orgId;// 机构ID

	@TableField(value = "REQ_URL")
	private String reqUrl;// 请求URL

	@TableField(value = "REQ_METHOD")
	private String reqMethod;// 方法名称

	@TableField(value = "REQ_MODE")
	private String reqMode;// 请求方式

	@TableField(value = "IP_ADDR")
	private String ipAddr;// IP地址

	@TableField(value = "REQ_PARAM")
	private String reqParam;// 请求参数

	@TableField(value = "RESULT")
	private String result;// 返回结果

	@TableField(value = "IS_OK")
	private String isOk;// 是否操作成功

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField(value = "LOG_TIME")
	private Date logTime;// 发生时间

}