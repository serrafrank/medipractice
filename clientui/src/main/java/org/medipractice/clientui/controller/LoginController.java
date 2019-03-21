package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private ProxyManager proxyManager;

    @GetMapping("/login")
    public String getToken(HttpSession request, Model model) {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView  postToken(@RequestParam String login, @RequestParam String password, HttpServletResponse request, Model model) {

        TokenBean tokenBean = this.proxyManager.getAuth().postLogin("password", "medipractice", "medipractice", login, password, "clientui");

        request.addCookie(new Cookie("access_token", tokenBean.getAccessToken()));
        request.addCookie(new Cookie("token_type", tokenBean.getTokenType()));

        return new RedirectView("/");
    }


}
