package com.example.poc.error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class GlobalErrorHandlerTest {

	@Test
	public void handleValidationException() {
		String errorMessage = "Invalid value";
		GlobalErrorHandler handler = new GlobalErrorHandler();
		RuntimeException e = new RuntimeException(errorMessage);
		ResponseEntity<ErrorResponse> response = handler.handleException(e);

		assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
		assertThat(response.getBody().getMessage(), equalTo("Invalid value"));
	}

	@Test
	public void handleExceptionTestNonResponseStatusException() {
		RuntimeException e = new RuntimeException("some random runtime exception occurred");
		GlobalErrorHandler handler = new GlobalErrorHandler();

		ResponseEntity<ErrorResponse> resp = handler.handleException(e);
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		assertThat(resp.getStatusCode(), equalTo(status));
		assertThat(Objects.requireNonNull(resp.getBody()).getMessage(),
				equalTo("some random runtime exception occurred"));
	}

	@Test
	public void handleExceptionTestWithResponseStatusException() {
		HttpStatus expectedStatus = HttpStatus.TOO_EARLY;
		ResponseStatusException e = new ResponseStatusException(expectedStatus, "too early");
		GlobalErrorHandler handler = new GlobalErrorHandler();

		ResponseEntity<ErrorResponse> resp = handler.handleException(e);

		assertThat(resp.getStatusCode(), equalTo(expectedStatus));
		assertThat(Objects.requireNonNull(resp.getBody()).getMessage(), equalTo("too early"));
	}

}
