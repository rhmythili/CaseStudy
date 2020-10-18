package com.example.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.entity.LoanDetailsDE;
import com.example.poc.entity.util.LoanDetailsUtil;
import com.example.poc.error.GlobalException;
import com.example.poc.model.LoanDetails;
import com.example.poc.repository.LoanDetailsRepository;

@Service
public class LoanDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalException.class);
	
	@Autowired
	LoanDetailsRepository loanDetailsRepository;

	@Transactional
	public void save(List<LoanDetails> loanDetailsList) {
		List<LoanDetailsDE> loanDetails = LoanDetailsUtil.mapModelToEntity(loanDetailsList);
		loanDetailsRepository.saveAll(loanDetails);
	}

	public List<LoanDetails> getLoanDetails() {
		Optional<List<LoanDetailsDE>> loanDetailsDEList = Optional.of(loanDetailsRepository.findAll());
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		for (LoanDetailsDE loanDetail : loanDetailsDEList.get()) {
			LoanDetails loanDetails = LoanDetailsUtil.mapEntityToModel(loanDetail);
			loanDetailsList.add(loanDetails);
		}
		LOGGER.info("Entered to get the loan details ");
		return loanDetailsList;
	}

}