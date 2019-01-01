package org.medipractice.pageserver.repository;

import org.medipractice.pageserver.model.Navigation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NavigationRepository extends CrudRepository<Navigation, UUID> {

    Optional<List<Navigation>> findAllByParentIsNull();

}
