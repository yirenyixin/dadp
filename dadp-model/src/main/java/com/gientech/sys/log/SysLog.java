package com.gientech.sys.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_LOG")
public class SysLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "LOG_ID", type = IdType.ASSIGN_ID)
	private String logId;// 日志ID

	@TableField(value = "USER_ID")
	private String userId;// 用户ID

	@TableField(value = "USER_NAME")
	private String userName;// 用户姓名

	@TableField(value = "LOG_INFO")
	private String logInfo;// 日志内容

	@TableField(value = "IP_ADDR")
	private String ipAddr;// IP地址

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@TableField(value = "LOG_TIME")
	private Date logTime;// 发生时间

}