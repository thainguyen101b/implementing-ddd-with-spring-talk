package library.catalog.infrastructure.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.catalog.domain.Book;
import library.catalog.domain.BookId;
import library.catalog.domain.Isbn;

import java.util.UUID;

@Entity
public class BookEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    public static BookEntity fromBook(Book book) {
        BookEntity entity = new BookEntity();
        entity.id = book.getId().id();
        entity.title = book.getTitle();
        entity.isbn = book.getIsbn().value();
        return entity;
    }

    public Book toBook() {
        BookId bookId = new BookId(id);
        String title = this.title;
        Isbn isbn = new Isbn(this.isbn);
        return Book.reconstitute(bookId, title, isbn);
    }
}
