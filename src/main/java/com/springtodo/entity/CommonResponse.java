package com.springtodo.entity;

public class CommonResponse {
	public final int code;
	public final String message;	

	public CommonResponse(String message) {
		this.code = 0;
		this.message = message;
	}
}
