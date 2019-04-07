package org.medipractice.clientui.controller;

import org.medipractice.clientui.UserAccountBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.ServiceManager;
import org.medipractice.clientui.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

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

}
