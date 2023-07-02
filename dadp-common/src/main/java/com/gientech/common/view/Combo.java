package com.gientech.common.view;

import java.io.Serializable;

import lombok.Data;

/**
 * Combo的数据，配合SysCodeInfo使用，只取里面的2~3个字段，在IncludeTag传递数据的时候，减少数据量(不要把每个字段都传过去)
 * 
 * @author 胡砥峰
 */
@Data
public class Combo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;// 下拉框值
	private String content;// 下拉框内容
	private String parentValue;// 上级联动下拉框值

	public Combo() {
	}

	public Combo(String value, String content) {
		this.value = value;
		this.content = content;
		this.parentValue = "";
	}

	public Combo(String value, String content, String parentValue) {
		this.value = value;
		this.content = content;
		this.parentValue = parentValue;
	}

}