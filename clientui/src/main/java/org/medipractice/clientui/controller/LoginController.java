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
        this.authProxy = authProxy;
    }

    @GetMapping("/login")
    public String getLogin(HttpSession request , Model model) {

        request.setAttribute("token" , authProxy.PostLogin("password", "medipractice", "medipractice", "admin", "admin", "clientui"));

        model.addAttribute("text", ((TokenBean) request.getAttribute("token")).getAccessToken());


        return "login";
    }

    /*
    @PostMapping("/login")
    public void postLogin() {


        return "login";
    }
    */
}
