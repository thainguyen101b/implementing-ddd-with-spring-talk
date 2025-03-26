package library.catalog.domain;

public interface BookRepository {

    void save(Book book);

    Book findByIsbn(Isbn isbn);

}
