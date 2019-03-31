package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataFileRepository extends JpaRepository<DataFile, UUID> {

    Optional<DataFile> findById(UUID id);

    Optional<List<DataFile>> findAllByDataFileAndArchivedAtIsNull(UUID id);

    Optional<DataFile> findByDataFileAndTypeAndArchivedAtIsNull(UUID id, String type);

    Optional<List<DataFile>> findAllByDataFileAndTypeInAndArchivedAtIsNull(UUID id, List<String> types);

    Optional<List<DataFile>> findAllByTypeInAndValueContainingAndArchivedAtIsNull(List<String> types, String value);

}


