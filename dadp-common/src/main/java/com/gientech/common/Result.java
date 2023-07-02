package com.gientech.common;

import java.io.Serializable;

import com.gientech.common.enums.ResultCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * REST API 全局统一返回结果
 * 
 * @author 胡砥峰、吴清赫
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 操作码
	 */
	private int code;

	/**
	 * 操作提示
	 */
	private String msg;

	/**
	 * 返回数据或数据集合
	 */
	private T data;

	/*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/

	/**
	 * 【1a】操作成功--默认提示
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> success() {
		return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
	}

	/**
	 * 【1b】操作成功--设定提示信息
	 * 
	 * @param <T>
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> success(String msg) {
		return new Result<>(ResultCode.SUCCESS.getCode(), msg, null);
	}

	/**
	 * 【1c】操作成功--设定返回数据
	 * 
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
	}

	/*------------------------------------我就是那华丽的分割线-------------------------------------------------------------------*/

	/**
	 * 【2a】操作失败--默认提示
	 * 
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> error() {
		return new Result<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMsg(), null);
	}

	/**
	 * 【2b】操作失败--设定提示信息
	 * 
	 * @param <T>
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(String msg) {
		return new Result<>(ResultCode.FAILED.getCode(), msg, null);
	}

	/**
	 * 【2c】操作失败--设定操作码和提示信息
	 * 
	 * @param <T>
	 * @param code
	 * @param msg
	 * @return
	 */
	public static <T> Result<T> error(int code, String msg) {
		return new Result<>(code, msg, null);
	}

}
