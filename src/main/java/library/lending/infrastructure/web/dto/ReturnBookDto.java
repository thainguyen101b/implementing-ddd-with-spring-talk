package library.lending.infrastructure.web.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ReturnBookDto(
        @NotNull UUID loanId
) {
}
