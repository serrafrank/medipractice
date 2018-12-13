package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DataValuesRepository extends JpaRepository<DataValue, UUID> {

    Optional<DataValue> findById(UUID id);

}
