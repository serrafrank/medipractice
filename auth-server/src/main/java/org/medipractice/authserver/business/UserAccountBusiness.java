package org.medipractice.authserver.business;

import org.medipractice.authserver.model.UserAccount;


public interface UserAccountBusiness {
    void createUser(UserAccount userAccount) throws Exception;

    UserAccount findByUsername(String username);
}
