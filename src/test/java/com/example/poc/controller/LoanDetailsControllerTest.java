package com.example.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.poc.model.LoanDetails;
import com.example.poc.service.LoanDetailsService;
import com.example.poc.service.TestData;

@ExtendWith(MockitoExtension.class)
public class LoanDetailsControllerTest {

	@InjectMocks
	private LoanDetailsController loanDetailsController;

	@Mock
	private LoanDetailsService loanDetailsService;

	List<LoanDetails> loanDetailsList = new ArrayList<>();;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		loanDetailsList = TestData.returnListOfLoanDetails();
	}

	@Test
	public void verifyAllUsersList() throws Exception {
		Mockito.when(loanDetailsService.getLoanDetails()).thenReturn(loanDetailsList);
		List<LoanDetails> loanDetails = loanDetailsController.listUser();
		Assert.assertEquals("Aarya Stark", loanDetails.get(0).getBorrowerName());
		Assert.assertArrayEquals(loanDetailsList.toArray(), loanDetails.toArray());

	}

	@Test
	public void verifyUsers() throws Exception {
		loanDetailsController.postUsers(loanDetailsList);
	}
}
