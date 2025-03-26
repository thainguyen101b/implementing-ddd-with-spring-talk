package library.catalog.domain;

import org.springframework.util.Assert;

import java.util.Objects;

public class Book {
    private final BookId id;
    private final String title;
    private final Isbn isbn;

    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "title must not be null");
        Assert.notNull(isbn, "isbn must not be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }

    Book(BookId id, String title, Isbn isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public static Book reconstitute(BookId id, String title, Isbn isbn) {
        return new Book(id, title, isbn);
    }

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
