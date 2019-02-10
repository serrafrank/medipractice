package org.medipractice.clientui.controller;


import org.medipractice.clientui.beans.menu.MenuBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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



    @GetMapping("/")
    public String index( Model model) {
        model.addAttribute("page", pageProxy.getPage("index"));
        return "index";
    }

//    @GetMapping("/{formName}")
//    public String index(@PathVariable @ModelAttribute("formName") String formName, Model model) {
//        model.addAttribute("page", pageProxy.getPage(formName));
//        return "index";
//    }
//
//    @GetMapping("/{formName}/edit")
//    public String edit(@PathVariable String formName, Model model) {
//        if(formName.isEmpty())
//            formName = "index";
//
//        model.addAttribute("page", pageProxy.getPage(formName));
//        return "edit";
//    }




}