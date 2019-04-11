package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@Slf4j
public class PageController extends AbstractController {

    @ModelAttribute("DataFile")
    private JSONObject getDatafile(@SessionAttribute("datafile") String datafile) {
        if(!datafile.isEmpty()) {
            UUID datafileId = UUID.fromString(datafile);
            List<DataFileBean> dataFile = this.serviceManager.getDataService().getDatas(datafileId);
            Map<String, String> datas = new HashMap<>();
            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));
            return new JSONObject(datas);
        }else {
            return null;
        }
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
        PageBean pageBean = this.serviceManager.getPageService().getPageContent(module, name);
        List<ModuleBean> menu;
        menu = this.serviceManager.getPageService().findMenu();

        ModuleBean moduleBean = menu.stream().filter(c -> c.getName().equals(module)).findFirst().get();

        model.addAttribute("module", menu.stream().filter(c -> c.getName().equals(module)).findFirst().get());
        model.addAttribute("page", this.serviceManager.getPageService().getPageContent(module, name));
        model.addAttribute("url", "/page/" + module + "/index");


        if (action == null) action = (pageBean.getId() != null) ? "read" : "edit";


        model.addAttribute("action", action);

    }
}
