package org.medipractice.formserver.repository;

import org.medipractice.formserver.model.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "form", path = "form")
public interface FormRepository extends CrudRepository<Field, UUID> {

    Optional<Field> findById(@Param("id") @RequestParam("id") UUID id);

}
