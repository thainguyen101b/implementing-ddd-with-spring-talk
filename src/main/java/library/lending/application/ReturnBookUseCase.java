package library.lending.application;

import library.lending.domain.Loan;
import library.lending.domain.LoanId;
import library.lending.domain.LoanRepository;

public class ReturnBookUseCase {

    private final LoanRepository loanRepository;

    public ReturnBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(LoanId loanId) {
        Loan loan = loanRepository.findById(loanId);
        loan.returned();
        loanRepository.save(loan);
    }
}
