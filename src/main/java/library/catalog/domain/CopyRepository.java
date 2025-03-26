package library.catalog.domain;

public interface CopyRepository {

    void save(Copy copy);

    Copy findById(CopyId id);

}
