package org.medipractice.authserver.business.contract;

import org.medipractice.authserver.model.UserToken;

import java.util.Optional;

public interface UserTokenBusiness {
    Optional<UserToken> getByUsername(String username) throws Exception;
}
