package com.example.poc.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Harsha
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDetails {
	
	@ApiModelProperty(notes = "Loan Number",name="Loan No",required=true,value="test loan no")
	private int loanNumber;

	@ApiModelProperty(notes = "Borrower Name",name="Borrower Name",required=true,value="test borrower name")
	private String borrowerName;

	@ApiModelProperty(notes = "DOB",name="DOB",required=true,value="test DOB")
	private String dob;

	@ApiModelProperty(notes = "Property Address",name="Property Address",required=true,value="test property address")
	private String propertyAddress;

	@ApiModelProperty(notes = "Property Value",name="Property Value",required=true,value="test property value")
	private double propertyValue;

	@ApiModelProperty(notes = "Flood Risk",name="Flood Risk",required=true,value="test flood risk")
	private String floodRisk;

}
