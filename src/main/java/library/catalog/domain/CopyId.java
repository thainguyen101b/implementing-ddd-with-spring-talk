package library.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CopyId(UUID id) {

    public CopyId {
        Assert.notNull(id, "id must not be null");
    }

    public CopyId() {
        this(UUID.randomUUID());
    }

    public static CopyId fromUUID(UUID uuid) {
        Assert.notNull(uuid, "copy id must not be null");
        return new CopyId(uuid);
    }
}
