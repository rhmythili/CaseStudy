package com.example.poc.service;

import java.util.ArrayList;
import java.util.List;

import com.example.poc.entity.LoanDetailsDE;
import com.example.poc.model.LoanDetails;

public class TestData {

	public static List<LoanDetailsDE> getloanDetailsDE() {
		List<LoanDetailsDE> loanDetailsDEList = new ArrayList<LoanDetailsDE>();
		LoanDetailsDE loanDetailsDE = new LoanDetailsDE();
		loanDetailsDE.setBorrowerName("ABC");
		loanDetailsDE.setDob("");
		loanDetailsDE.setFloodRisk("");
		loanDetailsDE.setLoanNumber(1);
		loanDetailsDE.setPropertyAddress("");
		loanDetailsDE.setPropertyValue(1l);
		loanDetailsDEList.add(loanDetailsDE);
		return loanDetailsDEList;
	}

	public static List<LoanDetails> returnListOfLoanDetails() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(100, "Aarya Stark", "01/01/2001", "The North", 100000, "No"));
		loanDetailsList.add(new LoanDetails(200, "Ned Stark", "01/01/1991", "The North", 100000, "No"));
		loanDetailsList.add(new LoanDetails(300, "Jon Snow", "02/02/2002", "Night's Watch", 9999, "Yes"));
		loanDetailsList.add(new LoanDetails(400, "Cersei Lannister", "01/01/1992", "King's Landing", 100000, "No"));
		return loanDetailsList;
	}

	public static List<LoanDetails> returnLoanDetailsListWithNullDob() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(100, "Aarya Stark", null, "The North", 100000, "No"));
		return loanDetailsList;
	}

	public static List<LoanDetails> returnLoanDetailsListWithNullBorrowerName() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(100, "Aarya Stark", "01/01/2001", null, 100000, "No"));
		return loanDetailsList;
	}

	public static List<LoanDetails> returnLoanDetailsListWithNullPropertyName() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(100, "Aarya Stark", "01/01/2001", null, 100000, null));
		return loanDetailsList;
	}

	public static List<LoanDetails> returnLoanDetailsListWithEmptyPropertyValue() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(100, "Aarya Stark", "01/01/2001", "The North", 0, "No"));
		return loanDetailsList;
	}

	public static List<LoanDetails> returnLoanDetailsListWithZeroLoanNumber() {
		List<LoanDetails> loanDetailsList = new ArrayList<>();
		loanDetailsList.add(new LoanDetails(0, "Aarya Stark", "01/01/2001", "The North", 100000, "No"));
		return loanDetailsList;
	}
}
