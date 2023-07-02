package com.gientech.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 枚举类型---操作码
 * 
 * @author 胡砥峰、吴清赫
 *
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

	/**
	 * 操作失败
	 */
	FAILED(-1, "操作失败"),

	/**
	 * 操作成功
	 */
	SUCCESS(200, "操作成功"),

	/**
	 * 没有权限
	 */
	NO_AUTH(998, "没有权限"),

	/**
	 * 登录超时
	 */
	TIME_OUT(999, "登录过期,请重新登录");

	/*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/

	private final int code;
	private final String msg;

}
