package library.catalog.application;


import library.catalog.domain.Copy;
import library.catalog.domain.CopyId;
import library.catalog.domain.CopyRepository;

public class MakeCopyUnavailableUseCase {

    private final CopyRepository copyRepository;

    public MakeCopyUnavailableUseCase(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public void execute(CopyId copyId) {
        Copy copy = copyRepository.findById(copyId);
        copy.makeUnavailable();
        copyRepository.save(copy);
    }

}
