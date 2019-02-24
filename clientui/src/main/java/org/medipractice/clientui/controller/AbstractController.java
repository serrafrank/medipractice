package org.medipractice.clientui.controller;

import org.medipractice.clientui.beans.TokenBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public abstract class AbstractController {


    private final HttpSession httpSession;

    protected String token;

    @Autowired
    public AbstractController( HttpSession httpSession) {
        this.httpSession = httpSession;
        TokenBean tokenBean = (TokenBean) this.httpSession.getAttribute("token");
        if (tokenBean != null)
            this.token = tokenBean.getTokenType() + " " + tokenBean.getAccessToken();

    }


}
