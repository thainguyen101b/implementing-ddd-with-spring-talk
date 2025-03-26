package library.catalog.infrastructure.jpa;

import library.catalog.domain.Copy;
import library.catalog.domain.CopyId;
import library.catalog.domain.CopyRepository;
import org.springframework.stereotype.Component;

@Component
public class CopyRepositoryAdapter implements CopyRepository {

    private final CopyJpaRepository repository;

    public CopyRepositoryAdapter(CopyJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Copy copy) {
        repository.save(CopyEntity.fromCopy(copy));
    }

    @Override
    public Copy findById(CopyId id) {
        CopyEntity entity = repository.findById(id.id()).orElseThrow();
        return entity.toCopy();
    }
}
