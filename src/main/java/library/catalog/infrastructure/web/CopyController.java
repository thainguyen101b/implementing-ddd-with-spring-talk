package library.catalog.infrastructure.web;

import jakarta.validation.Valid;
import library.catalog.application.RegisterBookCopyUseCase;
import library.catalog.domain.BarCode;
import library.catalog.domain.BookId;
import library.catalog.domain.Copy;
import library.catalog.domain.CopyRepository;
import library.catalog.infrastructure.web.dto.RegisterBookCopyDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/copies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CopyController {

    private final RegisterBookCopyUseCase registerBookCopyUseCase;
    private final CopyRepository copyRepository;

    public CopyController(RegisterBookCopyUseCase registerBookCopyUseCase, CopyRepository copyRepository) {
        this.registerBookCopyUseCase = registerBookCopyUseCase;
        this.copyRepository = copyRepository;
    }

    @PostMapping
    public ResponseEntity<Void> registerBookCopy(@RequestBody @Valid RegisterBookCopyDto dto) {
        BookId bookId = new BookId(dto.bookId());
        BarCode barCode = new BarCode(dto.barCode());
        registerBookCopyUseCase.execute(bookId, barCode);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public Copy findByBarCode(@PathVariable String code) {
        return copyRepository.findByBarCode(new BarCode(code));
    }

}
