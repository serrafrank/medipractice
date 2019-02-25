package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/")
@SessionAttributes( value="token", types={String.class} )
@Controller
@Slf4j
public class PageController {

    @Autowired
    private PageProxy pageProxy;


    @ModelAttribute("menu")
    private List<MenuBean> getMenu(HttpSession httpSession) {
        return pageProxy.findMenu( httpSession.getAttribute("token").toString());
    }


    @GetMapping()
    public String index(HttpSession httpSession, Model model) {
        model.addAttribute("page", pageProxy.getIndex( httpSession.getAttribute("token").toString()));
        return "read";

    }

    @GetMapping("{module}")
    public String index(@PathVariable String module,  HttpSession httpSession, Model model) {
            model.addAttribute("page", pageProxy.getPage(httpSession.getAttribute("token").toString(), module,  "index"));
        return "read";
    }

    @GetMapping("{module}/{name}")
    public String index(@PathVariable String module, @PathVariable String name, HttpSession httpSession, Model model) {

            model.addAttribute("page", pageProxy.getPage(httpSession.getAttribute("token").toString(), module, name));
        return "read";
    }

    @GetMapping("{module}/{name}/{action}")
    public String index(@PathVariable String module, @PathVariable String name, @PathVariable String action, HttpSession httpSession, Model model) {
            model.addAttribute("page", pageProxy.getPage(httpSession.getAttribute("token").toString(), module, name));
        return action;
    }

}