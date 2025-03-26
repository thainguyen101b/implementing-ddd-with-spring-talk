package library.lending.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record Borrower(UUID id) {

    public static Borrower fromUUID(UUID id) {
        Assert.notNull(id, "borrower id must not be null");
        return new Borrower(id);
    }
}
