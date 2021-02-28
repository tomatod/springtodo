package com.springtodo.entity;

public class ErrorResponse {
	public final int code;
	public final String message;	

	public ErrorResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
