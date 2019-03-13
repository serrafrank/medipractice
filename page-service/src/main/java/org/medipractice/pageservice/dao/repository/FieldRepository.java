package org.medipractice.pageservice.dao.repository;

import org.medipractice.pageservice.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FieldRepository extends JpaRepository<Field, UUID> {

    Optional<List<Field>> findAllByLabelContaining(@Param("label") String label);

}
