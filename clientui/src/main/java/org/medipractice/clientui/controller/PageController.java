package org.medipractice.clientui.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes(value = "token", types = {String.class})
@Controller
@Slf4j
public class PageController {

    @Autowired
    private PageProxy pageProxy;


    @ModelAttribute("menu")
    private List<MenuBean> getMenu(HttpSession httpSession) {
        return pageProxy.findMenu(httpSession.getAttribute("token").toString());
    }


    @GetMapping("/")
    public String getIndex(HttpSession httpSession, Model model) {
        PageBean pageBean = pageProxy.getIndex(httpSession.getAttribute("token").toString());
        model.addAttribute("page", pageBean);
        model.addAttribute("url", "/page/" + pageBean.getModule().getName() + "/" + pageBean.getName());
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
            pageBean = pageProxy.getPage(httpSession.getAttribute("token").toString(), module, name);
            action = (action != null) ? action : "read";
        } catch (Exception e) {
            pageBean = new PageBean();
            pageBean.setModule(new ModuleBean());
            pageBean.getModule().setName(module);
            pageBean.setName(name);
            pageBean.setSchema("{}");
            action = "create";
        }

        model.addAttribute("page", pageBean);
        model.addAttribute("url", "/page/" + module + "/" + name);
        model.addAttribute("action", action);
    }

}
