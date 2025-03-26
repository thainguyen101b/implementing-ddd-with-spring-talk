package library.catalog.infrastructure.web;

import jakarta.validation.Valid;
import library.catalog.application.AddBookToCatalogUseCase;
import library.catalog.domain.Book;
import library.catalog.domain.BookRepository;
import library.catalog.domain.Isbn;
import library.catalog.infrastructure.web.dto.AddBookToCatalogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final AddBookToCatalogUseCase addBookToCatalogUseCase;
    private final BookRepository bookRepository;

    public BookController(AddBookToCatalogUseCase addBookToCatalogUseCase,
                          BookRepository bookRepository) {
        this.addBookToCatalogUseCase = addBookToCatalogUseCase;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Void> addBookToCatalog(@RequestBody @Valid AddBookToCatalogDto dto) {
        addBookToCatalogUseCase.execute(new Isbn(dto.isbn()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return bookRepository.findByIsbn(new Isbn(isbn));
    }

}
