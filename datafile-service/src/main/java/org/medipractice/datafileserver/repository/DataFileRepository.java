package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataFileRepository extends JpaRepository<DataFile, UUID> {

    Optional<DataFile> findById(UUID id);

    List<DataFile> findAllByDataFileAndArchivedAtIsNull(UUID id);

    Optional<DataFile> findByDataFileAndTypeAndArchivedAtIsNull(UUID id, String type);

    List<DataFile> findAllByDataFileAndTypeInAndArchivedAtIsNull(UUID id,  String[] types);

    @Modifying
    List<DataFile> findAllByTypeInAndValueContainingIgnoreCaseAndArchivedIsNull( @Param("types") String[] types, @Param("val") String value);

    List<DataFile> findAllByTypeInAndArchivedAtIsNull(String[] types);
}


