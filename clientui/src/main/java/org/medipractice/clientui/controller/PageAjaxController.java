package org.medipractice.clientui.controller;

import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageAjaxController {

    private final PageProxy pageProxy;

    @Autowired
    public PageAjaxController(PageProxy pageProxy) {
        this.pageProxy = pageProxy;
    }


    @RequestMapping(value = "/ajax_getPage/{formName}", produces = "application/json")
    @ResponseBody
    public String ajaxReturn(@PathVariable @ModelAttribute("formName")  String formName, Model model) {
        return pageProxy.getPage(formName).getSchema();
    }

}
