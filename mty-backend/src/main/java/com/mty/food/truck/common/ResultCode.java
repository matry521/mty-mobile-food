package com.mty.food.truck.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务代码枚举
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

	/**
	 * 操作成功
	 */
	SUCCESS(0, "Success"),

	PARAMS(302, "params error"),

	/**
	 * 业务异常
	 */
	FAILURE(400, "Service exception"),

	/**
	 * 请求未授权
	 */
	UN_AUTHORIZED(401, "Request not authorized"),

	/**
	 * 404 没找到请求
	 */
	NOT_FOUND(404, "404 Request not found"),


	/**
	 * 不支持当前请求方法
	 */
	METHOD_NOT_SUPPORTED(405, "The current request method is not supported"),

	/**
	 * 不支持当前媒体类型
	 */
	MEDIA_TYPE_NOT_SUPPORTED(415, "The current media type is not supported"),

	/**
	 * 请求被拒绝
	 */
	REQ_REJECT(403, "Request denied"),

	/**
	 * 服务器异常
	 */
	INTERNAL_SERVER_ERROR(500, "系统异常，请联系管理员!"),

	/**
	 * 缺少必要的请求参数
	 */
	PARAM_MISS(400, "The required request parameters are missing"),

	/**
	 * 请求参数类型错误
	 */
	PARAM_TYPE_ERROR(400, "The request parameter type is incorrect"),

	/**
	 * 请求参数绑定错误
	 */
	PARAM_BIND_ERROR(400, "Incorrect binding of request parameters"),

	/**
	 * 参数校验失败
	 */
	PARAM_VALID_ERROR(400, "Parameter check failure"),
	;

	/**
	 * code编码
	 */
	final int code;
	/**
	 * 中文信息描述
	 */
	final String message;

}
