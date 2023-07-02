package com.gientech.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统用户表--用户状态
 * 
 * @author 胡砥峰
 *
 */
@Getter
@AllArgsConstructor
public enum UserStatus {

	VALID("1", "在职"),

	INVALID("2", "离职");

	/*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/
	private String value;
	private String content;
}
