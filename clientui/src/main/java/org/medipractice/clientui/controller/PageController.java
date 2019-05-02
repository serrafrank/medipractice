package org.medipractice.clientui.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@Slf4j
public class PageController extends AbstractController {

    @GetMapping("/")
    public String getIndex(Model model) {
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
        PageBean pageBean = this.serviceManager.getPageService().getPageContent(module, name);
        List<ModuleBean> menu;
        menu = this.serviceManager.getPageService().findMenu();

        model.addAttribute("module", menu.stream().filter(c -> c.getName().equals(module)).findFirst().get());
        model.addAttribute("page", this.serviceManager.getPageService().getPageContent(module, name));
        model.addAttribute("url", "/page/" + module + "/" + name);

        if (action == null) action = (pageBean.getId() != null) ? "read" : "edit";

        model.addAttribute("action", action);

    }
}
