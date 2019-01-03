package org.medipractice.pageserver.repository;

import org.medipractice.pageserver.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends CrudRepository<Menu, UUID> {

    List<Menu> findAllByOrderBySortAsc();

}
