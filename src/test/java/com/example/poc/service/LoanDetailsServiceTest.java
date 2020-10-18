
package com.example.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.poc.entity.LoanDetailsDE;
import com.example.poc.model.LoanDetails;
import com.example.poc.repository.LoanDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class LoanDetailsServiceTest {

	@Mock
	private LoanDetailsRepository loanDetailsRepository;

	@InjectMocks
	private LoanDetailsService loanDetailsService;

	List<LoanDetails> loanDetailsList = new ArrayList<>();
	List<LoanDetailsDE> loanDetailsDEList = new ArrayList<LoanDetailsDE>();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		loanDetailsList = TestData.returnListOfLoanDetails();
		loanDetailsDEList = TestData.getloanDetailsDE();

	}

	@Test
	public void testGetAllUsers() {
		when(loanDetailsRepository.findAll()).thenReturn(loanDetailsDEList);
		List<LoanDetails> result = loanDetailsService.getLoanDetails();
		assertEquals(1, result.size());
	}

	@Test
	public void testSaveUsers() {
		loanDetailsService.save(loanDetailsList);
	}

}
