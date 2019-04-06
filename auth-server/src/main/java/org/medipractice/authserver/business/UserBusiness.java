package org.medipractice.authserver.business;

import org.medipractice.authserver.model.UserAccount;


public interface UserBusiness {
    void createUser(UserAccount userAccount) throws Exception;
}
