package library.catalog.application;

import library.catalog.domain.BarCode;
import library.catalog.domain.BookId;
import library.catalog.domain.Copy;
import library.catalog.domain.CopyRepository;

public class RegisterBookCopyUseCase {
    private final CopyRepository copyRepository;

    public RegisterBookCopyUseCase(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public void execute(BookId bookId, BarCode barCode) {
        Copy bookCopy = new Copy(bookId, barCode);
        copyRepository.save(bookCopy);
    }
}
