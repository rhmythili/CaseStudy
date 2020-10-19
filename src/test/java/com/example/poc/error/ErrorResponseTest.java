package com.example.poc.error;

import org.junit.jupiter.api.Test;
import org.hamcrest.core.Is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ErrorResponseTest {
	@Test
	public void testErrorResponse() {
		String message = "Bad request";

		String status = "400";
		String exception = "my error message";

		ErrorResponse response = new ErrorResponse(message, status, exception);

		assertThat(response.getMessage(), Is.is(message));
		assertThat(response.getStatus(), Is.is(status));
		assertThat(response.getException(), Is.is(exception));
	}

}
