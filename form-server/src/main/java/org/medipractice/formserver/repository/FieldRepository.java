package org.medipractice.formserver.repository;

import io.swagger.annotations.Api;
import org.medipractice.formserver.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Api(tags = "Field")
@RepositoryRestResource(collectionResourceRel = "field", path = "field")
public interface FieldRepository extends CrudRepository<Field, UUID> {

    Optional<Field> findById(@Param("id") @RequestParam("id") UUID id);
}
