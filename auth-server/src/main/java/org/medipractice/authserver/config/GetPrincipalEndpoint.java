package org.medipractice.authserver.config;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@FrameworkEndpoint
public class GetPrincipalEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "/oauth/token/user")
    public Principal user(Principal user) {
        return user;
    }
}
