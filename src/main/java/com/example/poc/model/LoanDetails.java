package com.example.poc.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Harsha
 *
 */

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

	public int getLoanNumber() {
		return loanNumber;
	}

	/**
	 * @param loanNumber
	 */
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getFloodRisk() {
		return floodRisk;
	}

	public void setFloodRisk(String floodRisk) {
		this.floodRisk = floodRisk;
	}

	public LoanDetails(int loanNumber, String borrowerName, String dob, String propertyAddress, double propertyValue,
			String floodRisk) {
		super();
		this.loanNumber = loanNumber;
		this.borrowerName = borrowerName;
		this.dob = dob;
		this.propertyAddress = propertyAddress;
		this.propertyValue = propertyValue;
		this.floodRisk = floodRisk;
	}

	public LoanDetails() {
		super();
	}

}
