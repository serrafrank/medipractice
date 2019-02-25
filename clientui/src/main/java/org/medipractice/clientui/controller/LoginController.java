package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.proxies.AuthProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@SessionAttributes(value = "token", types = {String.class})
public class LoginController {

    private final AuthProxy authProxy;

    @Autowired
    public LoginController(AuthProxy authProxy) {
        super();
        this.authProxy = authProxy;
    }

    @GetMapping("/login")
    public String getToken(HttpSession request, Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postToken(@RequestParam String login, @RequestParam String password, HttpSession request, Model model) {

        TokenBean tokenBean = authProxy.PostLogin("password", "medipractice", "medipractice", login, password, "clientui");

        request.setAttribute("token", tokenBean.getTokenType() + " " + tokenBean.getAccessToken());

        return "index";
    }


}
