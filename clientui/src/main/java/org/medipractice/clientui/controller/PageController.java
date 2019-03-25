package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class PageController {

    @Autowired
    private PageService pageService;

    private List<ModuleBean> menu;

    @ModelAttribute("readOnly")
    private boolean isReadOnly(HttpSession httpSession) {
        return (httpSession.getAttribute("datafile") == null);
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("menu", pageService.findMenu());
        model.addAttribute("page", null);
        model.addAttribute("action", "index");


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


    private void getPage(String module, String name, String action, Model model) {
        PageBean pageBean = pageService.getPageContent(module, name);
        List<ModuleBean> menu;
        menu = pageService.findMenu();

        ModuleBean moduleBean = menu.stream().filter(c -> c.getName().equals(module)).findFirst().get();

        model.addAttribute("menu", menu);
        model.addAttribute("module", menu.stream().filter(c -> c.getName().equals(module)).findFirst().get());

        model.addAttribute("page", pageService.getPageContent(module, name));
        model.addAttribute("url", "/page/" + module + "/index");


        if (action == null) action = (pageBean.getId() != null) ? "read" : "edit";


        model.addAttribute("action", action);

    }
}
