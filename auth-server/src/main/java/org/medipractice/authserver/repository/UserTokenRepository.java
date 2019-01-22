package org.medipractice.authserver.repository;

import org.medipractice.authserver.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, UUID> {

    Optional<UserToken> findByUsername(String username);

}
