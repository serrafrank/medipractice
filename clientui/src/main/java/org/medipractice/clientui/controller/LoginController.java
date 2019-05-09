package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController  extends AbstractController {

    @GetMapping("/login")
    public String getToken(HttpServletResponse response, HttpSession httpSession) {
        logout(response, httpSession);

        return "login";
    }

    @PostMapping("/login")
    public RedirectView  postToken(@RequestParam String login, @RequestParam String password, HttpServletResponse response) {

        this.serviceManager.getAuthService().login(login, password, response);
        return new RedirectView("/");
    }


    @GetMapping("/logout")
    public RedirectView getLogout(HttpServletResponse response, HttpSession httpSession) {
        logout(response, httpSession);

        return new RedirectView("/");
    }



    private void logout(HttpServletResponse response, HttpSession httpSession) {
        log.info("***** Logout");
        httpSession.removeAttribute(HTTPSESSION_DATAFILE);
        this.serviceManager.getTokenService().removeToken(response);
    }

}
