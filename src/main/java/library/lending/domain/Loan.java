package library.lending.domain;

import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Loan {
    private final LoanId loanId;
    private final CopyId copyId;
    private final Borrower borrower;
    private final LoanPeriod loanPeriod;
    private LocalDateTime returnedAt;
    private final Set<LoanEvent> events = new HashSet<>();

    public Loan(CopyId copyId, Borrower borrower, LoanPeriod.PeriodType periodType) {
        Assert.notNull(copyId, "copyId must not be null");
        Assert.notNull(borrower, "borrower must not be null");
        Assert.notNull(periodType, "periodType must not be null");

        this.loanId = new LoanId();
        this.copyId = copyId;
        this.borrower = borrower;
        this.loanPeriod = LoanPeriod.startFromNow(periodType);
        addEvent(new LoanEvent.LoanCreated(copyId));
    }

    Loan(LoanId loanId, CopyId copyId, Borrower borrower, LoanPeriod loanPeriod, LocalDateTime returnedAt) {
        this.loanId = loanId;
        this.copyId = copyId;
        this.borrower = borrower;
        this.loanPeriod = loanPeriod;
        this.returnedAt = returnedAt;
    }

    public static Loan reconstitute(LoanId loanId, CopyId copyId, Borrower borrower, LoanPeriod loanPeriod, LocalDateTime returnedAt) {
        return new Loan(loanId, copyId, borrower, loanPeriod, returnedAt);
    }

    public void returned() {
        this.returnedAt = LocalDateTime.now();
        if (loanPeriod.isExceeded(returnedAt)) {
            // calculate fee
        }
        addEvent(new LoanEvent.LoanClosed(this.copyId));
    }

    private void addEvent(LoanEvent event) {
        Assert.notNull(event, "event must not be null");
        events.add(event);
    }

    public Set<LoanEvent> getEvents() {
        return Collections.unmodifiableSet(events);
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public CopyId getCopyId() {
        return copyId;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LoanPeriod getLoanPeriod() {
        return loanPeriod;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }
}
