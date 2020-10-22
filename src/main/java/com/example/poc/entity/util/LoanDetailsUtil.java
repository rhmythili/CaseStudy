package com.example.poc.entity.util;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.poc.entity.LoanDetailsDE;
import com.example.poc.model.LoanDetails;

/**
 * @author Harsha
 *
 */

public class LoanDetailsUtil {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * non-public constructor
	 *
	 */
	private LoanDetailsUtil() {
		throw new IllegalStateException("Utility Class");
	}

	public static LoanDetails mapEntityToModel(LoanDetailsDE loanDetailDE) {
		logger.info("Mapping Entity Data to the Model");
		return new LoanDetails(loanDetailDE.getLoanNumber(), loanDetailDE.getBorrowerName(), loanDetailDE.getDob(),
				loanDetailDE.getPropertyAddress(), loanDetailDE.getPropertyValue(), loanDetailDE.getFloodRisk());

	}

	public static List<LoanDetailsDE> mapModelToEntity(List<LoanDetails> loanDetailsList) {
		List<LoanDetailsDE> loanDetails = new ArrayList<>();

		loanDetailsList.stream().forEach(loanDetail -> {

			validateLoanDetail(loanDetail);
			LoanDetailsDE loanDetailDE = new LoanDetailsDE();

			loanDetailDE.setLoanNumber(loanDetail.getLoanNumber());
			loanDetailDE.setBorrowerName(loanDetail.getBorrowerName());
			loanDetailDE.setDob(loanDetail.getDob());
			loanDetailDE.setPropertyAddress(loanDetail.getPropertyAddress());
			loanDetailDE.setPropertyValue(loanDetail.getPropertyValue());
			loanDetailDE.setFloodRisk(loanDetail.getFloodRisk());
			loanDetails.add(loanDetailDE);
		});
		logger.info("Mapping Model Data to the Entity");
		return loanDetails;
	}

	static void validateLoanDetail(LoanDetails loanDetail) {
		DateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
		simpleDate.setLenient(false);

		if (loanDetail.getLoanNumber() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Loan number can't be zero for -" + loanDetail.getBorrowerName());
		} else {
			if (loanDetail.getBorrowerName() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Borrower name can't be null for Loan Number -  " + loanDetail.getLoanNumber());
			}
			if (loanDetail.getDob() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Date of Birth can't be null for Loan Number -" + loanDetail.getLoanNumber());
			}
			if (loanDetail.getDob() != null) {
				try {
					simpleDate.parse(loanDetail.getDob());
				} catch (java.text.ParseException e) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Date of Birth should be in MM/dd/yyyy format for Loan Number -"
									+ loanDetail.getLoanNumber());
				}
			}

			if (loanDetail.getPropertyAddress() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Property Address can't be null for Loan Number -" + loanDetail.getLoanNumber());
			}
			if (loanDetail.getPropertyValue() == 0) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Cost can't be zero for Loan Number-" + loanDetail.getLoanNumber());
			}
		}

	}
}
