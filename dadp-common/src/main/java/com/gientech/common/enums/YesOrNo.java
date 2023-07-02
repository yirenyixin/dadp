package com.gientech.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否成功
 * 
 *
 */
@Getter
@AllArgsConstructor
public enum YesOrNo {
	YES("1", "是"),

	NO("0", "否");

	/*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/
	private String value;
	private String content;

}
