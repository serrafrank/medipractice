package org.medipractice.clientui.controller;

import org.medipractice.clientui.UserAccountBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.ServiceManager;
import org.medipractice.clientui.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SessionAttributes(value = "datafile" , types = {String.class})
public abstract class AbstractController {


    @Autowired
    protected ServiceManager serviceManager;

    @Autowired
    protected ProxyManager proxyManager;

    @ModelAttribute("menu")
    private List<ModuleBean> getMenu() {
        return this.serviceManager.getPageService().findMenu();
    }

    @ModelAttribute("user")
    private UserAccountBean getUser(){
        return this.serviceManager.getUserService().getCurrentUser();
    }

    @ModelAttribute("datafile")
    private String setDatafile(){
        return " ";
    }

}
