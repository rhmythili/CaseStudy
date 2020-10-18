package com.example.poc.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import com.example.poc.entity.util.LoanDetailsUtil;
import com.example.poc.model.LoanDetails;
import com.example.poc.service.TestData;

public class LoanDetailsUtilTest {

	List<LoanDetails> loanDetailsListWithNullName = new ArrayList<>();
	List<LoanDetails> loanDetailsListWithZeroLoanNumber = new ArrayList<>();
	List<LoanDetails> loanDetailsListwithEmptyLoanAmount = new ArrayList<>();
	List<LoanDetails> loanDetailsListWithNullProperyAddress = new ArrayList<>();
	List<LoanDetails> loanDetailsListWithNullDob = new ArrayList<>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		loanDetailsListWithNullName = TestData.returnLoanDetailsListWithNullBorrowerName();
		loanDetailsListWithZeroLoanNumber = TestData.returnLoanDetailsListWithZeroLoanNumber();
		loanDetailsListwithEmptyLoanAmount = TestData.returnLoanDetailsListWithEmptyPropertyValue();
		loanDetailsListWithNullProperyAddress = TestData.returnLoanDetailsListWithNullPropertyName();
		loanDetailsListWithNullDob = TestData.returnLoanDetailsListWithNullDob();

	}

	@Test(expected = ResponseStatusException.class)
	public void testInvalidDob() {
		LoanDetailsUtil.mapModelToEntity(loanDetailsListWithNullDob);
	}

	@Test(expected = ResponseStatusException.class)
	public void testInvalidBorrowerName() {
		LoanDetailsUtil.mapModelToEntity(loanDetailsListWithNullName);
	}

	@Test(expected = ResponseStatusException.class)
	public void testInvalidPropertyAddress() {
		LoanDetailsUtil.mapModelToEntity(loanDetailsListWithNullProperyAddress);

	}

	@Test(expected = ResponseStatusException.class)
	public void testInvalidPropertyValue() {
		LoanDetailsUtil.mapModelToEntity(loanDetailsListwithEmptyLoanAmount);

	}

	@Test(expected = ResponseStatusException.class)
	public void testInvalidLoanNumber() {
		LoanDetailsUtil.mapModelToEntity(loanDetailsListWithZeroLoanNumber);

	}

}
