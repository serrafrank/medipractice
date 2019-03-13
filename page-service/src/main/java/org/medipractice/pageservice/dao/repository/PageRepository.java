package org.medipractice.pageservice.dao.repository;

import org.medipractice.pageservice.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PageRepository extends JpaRepository<Page, UUID> {

    Optional<Page> findByModule_NameAndName(@Param("Module") String module, @Param("name") String name);

}
