package library.lending.infrastructure.web;

import jakarta.validation.Valid;
import library.lending.application.RentBookUseCase;
import library.lending.application.ReturnBookUseCase;
import library.lending.domain.Borrower;
import library.lending.domain.CopyId;
import library.lending.domain.LoanId;
import library.lending.infrastructure.web.dto.RentBookDto;
import library.lending.infrastructure.web.dto.ReturnBookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/loans", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {

    private final RentBookUseCase rentBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;

    public LoanController(RentBookUseCase rentBookUseCase, ReturnBookUseCase returnBookUseCase) {
        this.rentBookUseCase = rentBookUseCase;
        this.returnBookUseCase = returnBookUseCase;
    }

    @PostMapping("/rent")
    public ResponseEntity<Void> rentBook(@RequestBody @Valid RentBookDto dto) {
        CopyId copyId = new CopyId(dto.copyId());
        Borrower borrower = new Borrower(dto.userId());
        rentBookUseCase.execute(copyId, borrower, dto.periodType());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/return")
    public ResponseEntity<Void> returnBook(@RequestBody @Valid ReturnBookDto dto) {
        LoanId loanId = new LoanId(dto.loanId());
        returnBookUseCase.execute(loanId);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
