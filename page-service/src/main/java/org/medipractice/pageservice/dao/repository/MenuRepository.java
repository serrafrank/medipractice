package org.medipractice.pageservice.dao.repository;

import org.medipractice.pageservice.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {

    List<Menu> findAllByRootIsTrueOrderBySortAsc();

}
