package library.lending.infrastructure.jpa;

import library.lending.domain.CopyId;
import library.lending.domain.Loan;
import library.lending.domain.LoanId;
import library.lending.domain.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class LoanRepositoryAdapter implements LoanRepository {

    private final LoanJpaRepository repository;

    public LoanRepositoryAdapter(LoanJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isAvailable(CopyId id) {
        return repository.isAvailable(id.id());
    }

    @Override
    public void save(Loan loan) {
        repository.save(LoanEntity.fromLoan(loan));
    }

    @Override
    public Loan findById(LoanId id) {
        LoanEntity entity = repository.findById(id.id()).orElseThrow();
        return entity.toLoan();
    }

}
