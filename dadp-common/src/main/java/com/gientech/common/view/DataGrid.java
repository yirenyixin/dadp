package com.gientech.common.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 后台向前台返回JSON,用于easyui的datagrid
 * 
 * @author 胡砥峰
 * 
 */
@Data
public class DataGrid<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> rows;// 每行记录
	private long total;// 总记录数

	public DataGrid() {
		this.rows = new ArrayList<>();
		this.total = 0L;
	}

	public DataGrid(List<T> rows, long total) {
		this.rows = rows;
		this.total = total;
	}

	public DataGrid(List<T> rows, long total, List<T> footer) {
		this.rows = rows;
		this.total = total;
	}

}