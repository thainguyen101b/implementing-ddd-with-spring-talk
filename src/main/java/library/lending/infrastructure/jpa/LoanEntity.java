package library.lending.infrastructure.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.lending.domain.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class LoanEntity extends AbstractAggregateRoot<LoanEntity> {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private UUID copyId;

    @Column(nullable = false, updatable = false)
    private UUID userId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime startAt;

    @Column(nullable = false, updatable = false)
    private LocalDate expectedReturnDate;

    private LocalDateTime returnedAt;

    public LoanEntity() {
    }

    public LoanEntity(Set<LoanEvent> events) {
        events.forEach(this::registerEvent);
    }

    public static LoanEntity fromLoan(Loan loan) {
        LoanEntity entity = new LoanEntity(loan.getEvents());
        entity.id = loan.getLoanId().id();
        entity.copyId = loan.getCopyId().id();
        entity.userId = loan.getBorrower().id();
        entity.startAt = loan.getLoanPeriod().startAt();
        entity.expectedReturnDate = loan.getLoanPeriod().expectedReturnDate();
        entity.returnedAt = loan.getReturnedAt();

        return entity;
    }

    public Loan toLoan() {
        LoanId loanId = new LoanId(this.id);
        CopyId copyId = new CopyId(this.copyId);
        Borrower borrower = new Borrower(this.userId);
        LoanPeriod loanPeriod = new LoanPeriod(this.startAt, this.expectedReturnDate);
        return Loan.reconstitute(loanId, copyId, borrower, loanPeriod, this.returnedAt);
    }

}
