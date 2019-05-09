package org.medipractice.clientui.service.impl;

import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.AuthService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service("authService")
public class AuthServiceImpl extends AbstractService implements AuthService {

    @Override
    public void login(String login, String password, HttpServletResponse response) {
        TokenBean tokenBean = this.proxyManager.getAuth().postLogin("password", "medipractice", "medipractice", login, password, "clientui").getBody();
        this.serviceManager.getTokenService().setToken(tokenBean, response);
    }

}
