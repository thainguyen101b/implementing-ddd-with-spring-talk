package library.catalog.infrastructure.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.catalog.domain.BarCode;
import library.catalog.domain.BookId;
import library.catalog.domain.Copy;
import library.catalog.domain.CopyId;

import java.util.UUID;

@Entity
public class CopyEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID bookId;

    @Column(nullable = false)
    private String barCode;

    @Column(nullable = false)
    private Boolean available = false;

    public static CopyEntity fromCopy(Copy copy) {
        CopyEntity entity = new CopyEntity();
        entity.id = copy.getId().id();
        entity.bookId = copy.getBookId().id();
        entity.barCode = copy.getBarCode().code();
        entity.available = copy.isAvailable();
        return entity;
    }

    public Copy toCopy() {
        CopyId copyId = new CopyId(id);
        BookId bookId = new BookId(this.bookId);
        BarCode barCode = new BarCode(this.barCode);

        return Copy.reconstitute(copyId, bookId, barCode, this.available);
    }

}
