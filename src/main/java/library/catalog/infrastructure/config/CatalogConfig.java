package library.catalog.infrastructure.config;

import library.catalog.application.*;
import library.catalog.domain.BookRepository;
import library.catalog.domain.CopyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {

    @Bean
    public AddBookToCatalogUseCase addBookToCatalogUseCase(
            BookSearchService bookSearchService,
            BookRepository bookRepository
    ) {
        return new AddBookToCatalogUseCase(bookSearchService, bookRepository);
    }

    @Bean
    public RegisterBookCopyUseCase registerBookCopyUseCase(
            CopyRepository copyRepository
    ) {
        return new RegisterBookCopyUseCase(copyRepository);
    }

    @Bean
    public MakeCopyAvailableUseCase makeCopyAvailableUseCase(
            CopyRepository copyRepository
    ) {
        return new MakeCopyAvailableUseCase(copyRepository);
    }

    @Bean
    public MakeCopyUnavailableUseCase makeCopyUnavailableUseCase(
            CopyRepository copyRepository
    ) {
        return new MakeCopyUnavailableUseCase(copyRepository);
    }

}
