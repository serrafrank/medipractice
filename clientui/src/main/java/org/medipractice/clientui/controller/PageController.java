package org.medipractice.clientui.controller;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.sql.Array;
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
    public String getIndex(@PathVariable String module, Model model, HttpSession httpSession) {
        getPage(module, "index", null, model, httpSession);
        return "index";
    }

    @GetMapping("/page/{module}/{name}")
    public String getIndex(@PathVariable String module, @PathVariable String name, Model model, HttpSession httpSession) {
        getPage(module, name, null, model, httpSession);
        return "index";
    }

    @GetMapping("/page/{module}/{name}/{action}")
    public String getIndex(@PathVariable String module, @PathVariable String name, @PathVariable String action, Model model, HttpSession httpSession) {
        getPage(module, name, action, model, httpSession);
        return "index";
    }


    private void getPage(String module, String name, String action, Model model, HttpSession httpSession) {
        PageBean pageBean = this.serviceManager.getPageService().getPageContent(module, name);
        this.menu = this.serviceManager.getPageService().findMenu();
        model.addAttribute("module", this.menu.stream().filter(c -> c.getName().equals(module)).findFirst().get());
        model.addAttribute("page", pageBean);
        model.addAttribute("url", "/page/" + module + "/" + name);


        if (action == null) action = (pageBean.getId() != null) ? "read" : "edit";

        Map<String, String> datas = new HashMap<>();
        if (httpSession.getAttribute(HTTPSESSION_DATAFILE) != null && ( pageBean.getFields() != null &&  pageBean.getFields().size() > 0)) {
            UUID datafileId = UUID.fromString((String) httpSession.getAttribute(HTTPSESSION_DATAFILE));
            List<DataFileBean> dataFile = this.serviceManager.getDataService().getDatas(datafileId, pageBean.getFields() );
            log.info(dataFile.toString());
            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));
        }
        model.addAttribute("formDatas", new JSONObject(datas));

        model.addAttribute("action", action);

    }

}
