package library.catalog.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;

public record AddBookToCatalogDto(
        @NotBlank
        String isbn
) {
}
