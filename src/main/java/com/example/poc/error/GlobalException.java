package com.example.poc.error;

import org.springframework.web.bind.annotation.ControllerAdvice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalException {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);

	/**
	 * Handle exception response entity.
	 *
	 * @param e the exception
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		LOGGER.info("Entered into Global Exception ");
		ErrorResponse errorResponse = new ErrorResponse();
		Throwable cause = e;
		if (e.getCause() != null) {
			cause = e.getCause();
		}
		if (cause instanceof ResponseStatusException) {
			errorResponse.setMessage(((ResponseStatusException) cause).getReason());
		} else {
			errorResponse.setMessage(cause.getMessage());
		}

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if (cause instanceof ResponseStatusException) {
			status = ((ResponseStatusException) cause).getStatus();
		}
		errorResponse.setException(e.getMessage());
		errorResponse.setStatus(status.getReasonPhrase());
		LOGGER.info("Exit from Global Exception");
		return new ResponseEntity<>(errorResponse, status);
	}

}
