package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class PageController {

    @Autowired
    private PageService pageService;

    @ModelAttribute("menu")
    private List<MenuBean> getMenu() {
        return pageService.findMenu();
    }

    @ModelAttribute("readOnly")
    private boolean isReadOnly(HttpSession httpSession) {
        return (httpSession.getAttribute("datafile") == null);
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        return "index";
    }


    @GetMapping("/page/{module}")
    public String getIndex(@PathVariable String module, Model model) {

        getPage(module, "index", null, model);

        return "index";
    }

    @GetMapping("/page/{module}/{name}")
    public String getIndex(@PathVariable String module, @PathVariable String name, Model model) {

        getPage(module, name, null, model);

        return "index";
    }

    @GetMapping("/page/{module}/{name}/{action}")
    public String getIndex(@PathVariable String module, @PathVariable String name, @PathVariable String action, Model model) {

        getPage(module, name, action, model);

        return "index";
    }




    private void getPage(String module, String name, String action, Model model){
        PageBean pageBean = pageService.getPageContent(module, name );
        model.addAttribute("page", pageService.getPageContent(module, name));
        model.addAttribute("url", "/page/" + module + "/index");


        if(action == null) action =  (pageBean.getId() != null) ? "read" : "write";


        model.addAttribute("action", action);

    }
}
