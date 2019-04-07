package org.medipractice.authserver.controller;

import org.medipractice.authserver.business.UserAccountBusiness;
import org.medipractice.authserver.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class UserController {

    @Autowired
    private UserAccountBusiness userAccountBusiness;

    @GetMapping("/user")
    public Principal getPrincipal(Principal user){
        return user;
    }

    @GetMapping("/user_account")
    public UserAccount getUser(Principal user) {
        return userAccountBusiness.findByUsername(user.getName());
    }
}
