package library.lending.domain;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanPeriod(LocalDateTime startAt, LocalDate expectedReturnDate) {

    public enum PeriodType {
        THIRTY_DAYS,
        SIXTY_DAYS
    }

    public static LoanPeriod startFromNow(PeriodType type) {
        Assert.notNull(type, "loan periodType must not be null");

        LocalDateTime startAt = LocalDateTime.now();
        return switch (type) {
            case THIRTY_DAYS -> new LoanPeriod(startAt, LocalDate.now().plusDays(30));
            case SIXTY_DAYS -> new LoanPeriod(startAt, LocalDate.now().plusDays(60));
        };
    }

    public boolean isExceeded(LocalDateTime returnAt) {
        Assert.notNull(returnAt, "loan returnAt must not be null");

        return returnAt.isAfter(expectedReturnDate.atStartOfDay());
    }

}
