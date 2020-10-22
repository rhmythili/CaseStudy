package com.example.poc.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.example.poc.model.LoanDetails;
import com.example.poc.service.LoanDetailsService;

@CrossOrigin
@RestController
@Api(value = "LoanDetailsController")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Returns 200 if request successfully processed"),
		@ApiResponse(code = 400, message = "Return 400 if mandatory request parameters are not passed"),
		@ApiResponse(code = 401, message = "You are not authorized to view the Resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Returns 500 if Internal Server Error") })

public class LoanDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private LoanDetailsService loanDetailsService;

	@ApiOperation(value = "Get list of Loans from the database ", response = LoanDetails.class, tags = "users")
	@GetMapping(value = "/users")
	public List<LoanDetails> listUser() {
		logger.info("Returning all the loan details");
		return loanDetailsService.getLoanDetails();
	}

	@ApiOperation(value = "Save loan details in the database ", response = LoanDetails.class, tags = "postUsers")
	@PostMapping(value = "/users")
	public void postUsers(@RequestBody List<LoanDetails> loanDetails) {
		logger.info("Save the loan details");
		loanDetailsService.save(loanDetails);
	}

}
