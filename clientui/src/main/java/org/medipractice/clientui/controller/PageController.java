package org.medipractice.clientui.controller;


import org.medipractice.clientui.beans.menu.MenuBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class PageController {

    private final PageProxy pageProxy;

    @Autowired
    public PageController(PageProxy pageProxy) {
        this.pageProxy = pageProxy;
    }


    @ModelAttribute("menu")
    private List<MenuBean> getMenu(){
        return pageProxy.findMenu();
    }



    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("page", pageProxy.getIndex());
        return "index";
    }

    @RequestMapping("{module}/{name}/{action}")
    public String index(@PathVariable String module, @PathVariable String name, @PathVariable String action, Model model) {

        if (name == null) name = "index";
        if (action == null) action = "read";

        model.addAttribute("page", pageProxy.getPage(module, name));
        return action;
    }

}}