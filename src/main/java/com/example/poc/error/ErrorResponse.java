package com.example.poc.error;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	public ErrorResponse() {
		super();
	}

	private String message;
	private String status;
	private String exception;

	public String getMessage() {
		return message;
	}

	public ErrorResponse(String message, String status, String exception) {
		super();
		this.message = message;
		this.status = status;
		this.exception = exception;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}