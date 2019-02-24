package org.medipractice.clientui.controller;


import org.medipractice.clientui.beans.TokenBean;
import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/")
@Controller
public class PageController {

    @Autowired
    private PageProxy pageProxy;

    @Autowired
    private HttpSession httpSession ;


    private String token;

    public PageController() {
        token = httpSession.getAttribute("token").toString();

    }

    @ModelAttribute("menu")
    private List<MenuBean> getMenu() {
        return pageProxy.findMenu(token);
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("page", pageProxy.getIndex(token));
        return "index";

    }

    @GetMapping("{module}/{name}/{action}")
    public String index(@PathVariable String module, @PathVariable String name, @PathVariable String action, Model model) {

        if (name == null) name = "index";
        if (action == null) action = "read";

        model.addAttribute("page", pageProxy.getPage(token, module, name));
        return action;
    }

}