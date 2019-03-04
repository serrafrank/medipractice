package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        model.addAttribute("page", pageProxy.getIndex(httpSession.getAttribute("token").toString()));
        model.addAttribute("action", "read");
        return "index";

    }

    @GetMapping("/page/{module}")
    public String getIndex(@PathVariable String module, HttpSession httpSession, Model model) {
        model.addAttribute("page", pageProxy.getPage(httpSession.getAttribute("token").toString(), module, "index"));
        model.addAttribute("action", "read");
        return "index";
    }

    @PostMapping(value = "/page/{module}/{name}/edit",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE,  MediaType.APPLICATION_JSON_VALUE})
    public void postIndex(@PathVariable String module, @PathVariable String name, @RequestBody PageBean page , HttpServletResponse httpServletResponse, HttpSession httpSession, Model model) {
        model.addAttribute("page", pageProxy.postPage(httpSession.getAttribute("token").toString(), page));

        httpServletResponse.setHeader("Location", "/page/" +module+ "/" + name);
    }

    @GetMapping("/page/{module}/{name}/{action}")
    public String getIndex(@PathVariable String module, @PathVariable String name, @PathVariable String action, HttpSession httpSession, Model model) {
        model.addAttribute("url", "/page/" +module+ "/" + name + "/"+action);
        model.addAttribute("page", pageProxy.getPage(httpSession.getAttribute("token").toString(), module, name));
        model.addAttribute("action", action);
        return "index";
    }

}