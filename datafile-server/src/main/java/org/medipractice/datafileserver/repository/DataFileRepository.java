package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataFileRepository extends JpaRepository<DataFile, UUID> {

    Optional<DataFile> findById(UUID id);

//    Optional<List<DataFile>> findAllByDatas

}
