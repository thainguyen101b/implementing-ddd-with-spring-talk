package library.lending.application;

import library.lending.domain.*;
import org.springframework.util.Assert;

public class RentBookUseCase {
    private final LoanRepository loanRepository;

    public RentBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(CopyId copyId, Borrower borrower, LoanPeriod.PeriodType periodType) {
        Assert.isTrue(loanRepository.isAvailable(copyId), "copy with id = " + copyId + " is not available");
        Loan loan = new Loan(copyId, borrower, periodType);
        loanRepository.save(loan);
    }
}
