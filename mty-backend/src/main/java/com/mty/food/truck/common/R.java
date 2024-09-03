package com.mty.food.truck.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 */
@Data
@ToString
@Schema(description = "返回信息")
@NoArgsConstructor
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "状态码", required = true)
	private int code;
	@Schema(description = "是否成功", required = true)
	private boolean success;
	@Schema(description = "承载数据")
	private T data;
	@Schema(description = "返回消息", required = true)
	private String message;

	private R(IResultCode resultCode) {
		this(resultCode, null, resultCode.getMessage());
	}

	private R(IResultCode resultCode, String msg) {
		this(resultCode, null, msg);
	}

	private R(IResultCode resultCode, T data) {
		this(resultCode, data, resultCode.getMessage());
	}

	private R(IResultCode resultCode, T data, String msg) {
		this(resultCode.getCode(), data, msg);
	}

	private R(int code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.message = msg;
		this.success = ResultCode.SUCCESS.code == code;
	}


	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data) {
		return data(data, "SUCCESS");
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data, String msg) {
		return data(0, data, msg);
	}

	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param data 数据
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(int code, T data, String msg) {
		return new R<>(code, data, data == null ? "操作成功" : msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(String msg) {
		return new R<>(ResultCode.SUCCESS, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode) {
		return new R<>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(IResultCode resultCode, String msg) {
		return new R<>(resultCode, msg);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(String msg) {
		return new R<>(ResultCode.FAILURE, msg);
	}


	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param msg  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(int code, String msg) {
		return new R<>(code, null, msg);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode) {
		return new R<>(resultCode);
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 业务代码
	 * @param msg        消息
	 * @param <T>        T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(IResultCode resultCode, String msg) {
		return new R<>(resultCode, msg);
	}

	/**
	 * 返回R
	 *
	 * @param flag 成功状态
	 * @return R
	 */
	public static <T> R<T> status(boolean flag) {
		return flag ? success("操作成功") : fail("操作失败");
	}

	/**
	 * 返回R
	 *
	 * @param resultCode 状态集合
	 * @return R
	 */
	public static <T> R<T> status(IResultCode resultCode) {
		return resultCode.getCode()==0 ? success(resultCode.getMessage()) : fail(resultCode.getMessage());
	}
}
