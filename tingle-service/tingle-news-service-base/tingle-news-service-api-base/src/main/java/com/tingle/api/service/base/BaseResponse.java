package com.tingle.api.service.base;

import lombok.Data;

/**
 * 
 * 
 * @description: Uniform return code of microservice interface
 * @author: Ireck
 * @date: 20200106
 * @version V1.0
 */
@Data
public class BaseResponse<T> {

	/**
	 * response code
	 */
	private Integer code;
	/**
	 * response msg
	 */
	private String msg;
	/**
	 * response Data
	 */
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
