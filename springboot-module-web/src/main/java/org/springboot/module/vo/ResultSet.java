package org.springboot.module.vo;

import lombok.Data;

@Data
public class ResultSet<T> {
	private static final Integer CODE_SUCCESS = 0;
	private static final Integer CODE_ERROR = -1;
	//private static final Integer CODE_UNAUTH = -100;
	//private static final Integer CODE_SYSERR = -500;
	
	private static final String MSG_SUCCESS = "success";
	private static final String MSG_ERROR = "error";
	
	private Integer status;
	private String message;
	private T payload;

	public ResultSet(Integer status, String message, T payload) {
		super();
		this.status = status;
		this.message = message;
		this.payload = payload;
	}
	
	public static<T> ResultSet<T> newSuccessResult(T data){
		return new ResultSet<T>(CODE_SUCCESS, MSG_SUCCESS, data);
	}
	
	public static<T> ResultSet<T> newFailedResult(T data){
		return new ResultSet<T>(CODE_ERROR, MSG_ERROR, data);
	}

}
