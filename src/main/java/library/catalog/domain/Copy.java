package library.catalog.domain;

import org.springframework.util.Assert;

import java.util.Objects;

public class Copy {
    private final CopyId id;
    private final BookId bookId;
    private final BarCode barCode;
    private boolean available;

    public Copy(BookId bookId, BarCode barCode) {
        Assert.notNull(bookId, "bookId must not be null");
        Assert.notNull(barCode, "barCode must not be null");
        this.id = new CopyId();
        this.bookId = bookId;
        this.barCode = barCode;
        this.available = true;
    }

    Copy(CopyId id, BookId bookId, BarCode barCode, boolean available) {
        this.id = id;
        this.bookId = bookId;
        this.barCode = barCode;
        this.available = available;
    }

    public static Copy reconstitute(CopyId id, BookId bookId, BarCode barCode, boolean available) {
        return new Copy(id, bookId, barCode, available);
    }

    public void makeUnavailable() {
        this.available = false;
    }

    public void makeAvailable() {
        this.available = true;
    }

    public CopyId getId() {
        return id;
    }

    public BookId getBookId() {
        return bookId;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return Objects.equals(id, copy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
