package org.medipractice.datafileserver.repository;

import org.medipractice.datafileserver.model.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DataObjectRepository extends JpaRepository<DataObject, UUID> {

    Optional<DataObject> findById(UUID id);

}
