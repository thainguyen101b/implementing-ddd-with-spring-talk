package library.catalog.infrastructure.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RegisterBookCopyDto(
        @NotNull UUID bookId, @NotBlank String barCode
) {
}
