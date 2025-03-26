package library.lending.infrastructure.web.dto;

import jakarta.validation.constraints.NotNull;
import library.lending.domain.LoanPeriod;

import java.util.UUID;

public record RentBookDto(
        @NotNull UUID copyId,
        @NotNull UUID userId,
        @NotNull LoanPeriod.PeriodType periodType
) {
}
