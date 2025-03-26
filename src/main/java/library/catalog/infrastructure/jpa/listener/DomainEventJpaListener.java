package library.catalog.infrastructure.jpa.listener;

import library.catalog.application.MakeCopyAvailableUseCase;
import library.catalog.application.MakeCopyUnavailableUseCase;
import library.catalog.domain.CopyId;
import library.lending.domain.LoanEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class DomainEventJpaListener {

    private final MakeCopyAvailableUseCase makeCopyAvailableUseCase;
    private final MakeCopyUnavailableUseCase makeCopyUnavailableUseCase;

    public DomainEventJpaListener(MakeCopyAvailableUseCase makeCopyAvailableUseCase,
                                  MakeCopyUnavailableUseCase makeCopyUnavailableUseCase) {
        this.makeCopyAvailableUseCase = makeCopyAvailableUseCase;
        this.makeCopyUnavailableUseCase = makeCopyUnavailableUseCase;
    }

    @ApplicationModuleListener
    public void handleLoanCreated(LoanEvent.LoanCreated e) {
        makeCopyUnavailableUseCase.execute(CopyId.fromUUID(e.copyId().id()));
    }

    @ApplicationModuleListener
    public void handleLoanClosed(LoanEvent.LoanClosed e) {
        makeCopyAvailableUseCase.execute(CopyId.fromUUID(e.copyId().id()));
    }

}
