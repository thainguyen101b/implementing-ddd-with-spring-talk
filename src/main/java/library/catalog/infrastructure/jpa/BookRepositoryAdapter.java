package library.catalog.infrastructure.jpa;

import library.catalog.domain.Book;
import library.catalog.domain.BookRepository;
import library.catalog.domain.Isbn;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryAdapter implements BookRepository {

    private final BookJpaRepository repository;

    public BookRepositoryAdapter(BookJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Book book) {
        repository.save(BookEntity.fromBook(book));
    }

    @Override
    public Book findByIsbn(Isbn isbn) {
        BookEntity bookEntity = repository.findByIsbn(isbn.value())
                .orElseThrow();
        return bookEntity.toBook();
    }

}
