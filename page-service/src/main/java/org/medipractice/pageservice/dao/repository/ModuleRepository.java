package org.medipractice.pageservice.dao.repository;

import org.medipractice.pageservice.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModuleRepository extends JpaRepository<Module, UUID> {

    List<Module> findAllByOrderBySortAsc();

    Optional<Module> findByLabel(@Param("label") String label);

}
