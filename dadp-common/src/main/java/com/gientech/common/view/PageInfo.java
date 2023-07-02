package com.gientech.common.view;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页model---查询datagrid向后台传递参数使用的
 * 
 * @author 胡砥峰
 * 
 */
@Data
@NoArgsConstructor
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageNo = 1;// 当前页
	private int pageSize = 10;// 每页显示记录数
	private String sort = null;// 排序字段名(多个用逗号分隔)
	private String order = "asc";// 按什么排序(asc,desc)

	public PageInfo(Integer pageNo, Integer pageSize) {
		super();
		if (pageNo != null && pageNo > 0) {
			this.pageNo = pageNo;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	public PageInfo(Integer pageNo, Integer pageSize, String sort, String order) {
		super();
		if (pageNo != null && pageNo > 0) {
			this.pageNo = pageNo;
		}
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}

		this.sort = sort;
		this.order = order;
	}

	public PageInfo export() {
		this.pageSize = -1;
		return this;
	}

}
