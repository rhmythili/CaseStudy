package com.example.poc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "LOAN_DETAILS", schema = "dbo")
public class LoanDetailsDE implements Serializable {

	/**
	 * Entity Class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "loan_number", unique = true, nullable = false)
	private int loanNumber;

	@Column(name = "borrower_name", nullable = false)
	private String borrowerName;

	@JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
	@Column(name = "date_of_birth", nullable = false)
	private String dob;

	@Column(name = "property_address", nullable = false)
	private String propertyAddress;

	@Column(name = "property_value", nullable = false)
	private double propertyValue;

	@Column(name = "flood_risk")
	private String floodRisk;

	public int getLoanNumber() {
		return loanNumber;
	}

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

	

}
