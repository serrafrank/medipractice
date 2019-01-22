package org.medipractice.authserver.config;

import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Resource
    ConsumerTokenServices tokenServices;

    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token/revoke")
    @ResponseBody
    public String revokeToken(@RequestBody String token) {
        tokenServices.revokeToken(token);
        return token;
    }
}