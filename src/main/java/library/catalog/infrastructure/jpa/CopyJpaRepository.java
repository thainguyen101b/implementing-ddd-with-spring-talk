package library.catalog.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CopyJpaRepository extends JpaRepository<CopyEntity, UUID> {
    Optional<CopyEntity> findByBarCode(String barCode);
}
