package com.seavus.dataaccess;

import java.util.List;

import com.seavus.domain.Loan;

public interface LoanRepository {
	public void registerLoan(Loan loan);
	public List<Loan> listLoans();
}
