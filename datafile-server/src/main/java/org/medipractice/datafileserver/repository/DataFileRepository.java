package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataFileRepository extends JpaRepository<DataFile, UUID> {

    Optional<DataFile> findById(UUID id);

    @Query("SELECT d FROM DataFile d LEFT JOIN d.datas o LEFT JOIN o.values v  WHERE o.type IN :datatypes AND lower(v.value) like lower(concat('%', :datavalue,'%'))")
    Optional<List<DataFile>> findAllByDataTypesAndValue(@Param("datatypes") List<String> datatypes, @Param("datavalue") String datavalue);

}


