package org.medipractice.clientui.controller;

import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.proxies.AuthProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final AuthProxy authProxy;

    @Autowired
    public LoginController(AuthProxy authProxy) {
        super();
        this.authProxy = authProxy;
    }

    @GetMapping("/login")
    public String getToken(HttpSession request , Model model) {

        TokenBean tokenBean = authProxy.PostLogin("password", "medipractice", "medipractice", "admin", "admin", "clientui");

        request.setAttribute("token" , tokenBean.getTokenType() + " " + tokenBean.getAccessToken()  );

        model.addAttribute("text", ((TokenBean) request.getAttribute("token")).getAccessToken());


        return "login";
    }


}
