package org.medipractice.authserver.business;

import org.medipractice.authserver.model.User;

import java.util.List;


public interface UserBusiness {

    User findByUsername(String name);

    List<User> findAll();

}
