package library.lending.infrastructure.config;

import library.lending.application.RentBookUseCase;
import library.lending.application.ReturnBookUseCase;
import library.lending.domain.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LendingConfig {

    @Bean
    public RentBookUseCase rentBookUseCase(LoanRepository loanRepository) {
        return new RentBookUseCase(loanRepository);
    }

    @Bean
    public ReturnBookUseCase returnBookUseCase(LoanRepository loanRepository) {
        return new ReturnBookUseCase(loanRepository);
    }

}
