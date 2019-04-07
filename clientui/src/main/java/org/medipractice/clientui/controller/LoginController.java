package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class LoginController  extends AbstractController {

    @GetMapping("/login")
    public String getToken(HttpServletResponse response) {
        this.serviceManager.getTokenService().removeToken(response);

        return "login";
    }

    @PostMapping("/login")
    public RedirectView  postToken(@RequestParam String login, @RequestParam String password, HttpServletResponse request) {

        TokenBean tokenBean = this.proxyManager.getAuth().postLogin("password", "medipractice", "medipractice", login, password, "clientui");

        log.info(tokenBean.toString());

        request.addCookie( new Cookie("token_access", tokenBean.getAccessToken()));
        request.addCookie(new Cookie("token_type", tokenBean.getTokenType()));

        return new RedirectView("/");
    }


    @GetMapping("/logout")
    public RedirectView getLogout(HttpServletResponse response) {
        this.serviceManager.getTokenService().removeToken(response);
        return new RedirectView("/");
    }

}
