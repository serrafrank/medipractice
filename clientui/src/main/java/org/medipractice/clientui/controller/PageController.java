package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.service.DataService;
import org.medipractice.clientui.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@Slf4j
public class PageController {

    private final PageService pageService;
    private final DataService dataService;
    private final HttpSession httpSession;

    private List<ModuleBean> menu = new ArrayList<>();

    @Autowired
    public PageController(PageService pageService, HttpSession httpSession, DataService dataService) {
        this.pageService = pageService;
        this.httpSession = httpSession;
        this.dataService = dataService;
    }


    @ModelAttribute("datafile")
    private JSONObject getDatafile() {
        //UUID datafileId = (UUID) this.httpSession.getAttribute("datafile");
        UUID datafileId = UUID.fromString("77d2f026-0e20-4cc6-9ac4-66c4aa1f214b");

        if(datafileId != null){

            List<DataFileBean> dataFile = this.dataService.getDatas(datafileId);
            Map<String, String> datas = new HashMap<>();
            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));
            return new JSONObject(datas);
        }else{
            return null;
        }
    }

    @ModelAttribute("menu")
    private List<ModuleBean> getMenu() {
        this.menu = this.pageService.findMenu();
        return this.menu;
    }


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
        PageBean pageBean = pageService.getPageContent(module, name);
        List<ModuleBean> menu;
        menu = pageService.findMenu();

        ModuleBean moduleBean = menu.stream().filter(c -> c.getName().equals(module)).findFirst().get();

        model.addAttribute("module", menu.stream().filter(c -> c.getName().equals(module)).findFirst().get());
        model.addAttribute("page", pageService.getPageContent(module, name));
        model.addAttribute("url", "/page/" + module + "/index");


        if (action == null) action = (pageBean.getId() != null) ? "read" : "edit";


        model.addAttribute("action", action);

    }
}
