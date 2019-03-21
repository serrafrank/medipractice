package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@SessionAttributes(value = "token", types = {String.class})
@Controller
@Slf4j
public class PageController {

    @Autowired
    private PageProxy pageProxy;

    private List<ModuleBean> menu;


    @ModelAttribute("menu")
    private List<ModuleBean> getMenu(HttpSession httpSession) {
        this.menu = pageProxy.findMenu(httpSession.getAttribute("token").toString());
        return menu;
    }


    @GetMapping("/")
    public String getIndex(HttpSession httpSession, Model model) {
        PageBean pageBean = pageProxy.getIndex(httpSession.getAttribute("token").toString());
        model.addAttribute("page", pageBean);
        model.addAttribute("action", "read");
        return "index";

    }

    @GetMapping("/page/{module}")
    public String getIndex(@PathVariable String module, HttpSession httpSession, Model model) {
        getPageContent(module, "index", httpSession, model, "read");
        return "index";
    }

    @GetMapping("/page/{module}/{name}")
    public String getIndex(@PathVariable String module, @PathVariable String name, HttpSession httpSession, Model model) {
        getPageContent(module, name, httpSession, model, "read");
        return "index";
    }

    @GetMapping("/page/{module}/{name}/{action}")
    public String getIndex(@PathVariable String module, @PathVariable String name, @PathVariable String action, HttpSession httpSession, Model model) {
        getPageContent(module, name, httpSession, model, action);
        return "index";
    }


    private void getPageContent(String module, String name, HttpSession httpSession, Model model, String action) {
        PageBean pageBean;
        try {
            ModuleBean curentPage = this.menu.stream().filter(m -> m.getName().equals(module)).findFirst().orElse(null);

            pageBean = pageProxy.getPage(httpSession.getAttribute("token").toString(), module, name);
            action = (action != null) ? action : "read";
        } catch (Exception e) {
            pageBean = new PageBean();
            pageBean.setName(name);
            pageBean.setSchema("{}");
            action = "create";
        }


        model.addAttribute("module", module);
        model.addAttribute("page", pageBean);
        model.addAttribute("url", "/page/" + module + "/" + name);
        model.addAttribute("action", action);
    }

}
