package library.lending.domain;

public interface LoanRepository {

    boolean isAvailable(CopyId id);

    void save(Loan loan);

    Loan findById(LoanId id);

}
