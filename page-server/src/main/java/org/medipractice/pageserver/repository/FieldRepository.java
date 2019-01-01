package org.medipractice.pageserver.repository;

import org.medipractice.pageserver.model.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FieldRepository extends CrudRepository<Field, UUID> {

    Optional<List<Field>> findAllByLabelContaining(@Param("label") String label);

    Optional<Field> findByFieldKey(@Param("key") String key);
}
