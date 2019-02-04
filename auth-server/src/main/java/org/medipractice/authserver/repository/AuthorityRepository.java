package org.medipractice.authserver.repository;

import org.medipractice.authserver.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}
