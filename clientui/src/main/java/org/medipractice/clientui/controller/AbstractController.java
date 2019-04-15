package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.UserAccountBean;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.ServiceManager;
import org.medipractice.clientui.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
public abstract class AbstractController {


    @Autowired
    protected ServiceManager serviceManager;

    @Autowired
    protected ProxyManager proxyManager;

    @ModelAttribute("menu")
    private List<ModuleBean> getMenu() {
        return this.serviceManager.getPageService().findMenu();
    }

    @ModelAttribute("user")
    private UserAccountBean getUser() {
        return this.serviceManager.getUserService().getCurrentUser();
    }

    @ModelAttribute("datafile")
    private JSONObject getDatafile(HttpSession httpSession) {
        Map<String, String> datas = new HashMap<>();
        if (httpSession.getAttribute("datafile_id") != null) {
            String datafile_id = (String) httpSession.getAttribute("datafile_id");
            log.info("--- getDatafile " + datafile_id);
            UUID datafileId = UUID.fromString(datafile_id);
            List<DataFileBean> dataFile = this.serviceManager.getDataService().getDatas(datafileId);

            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));

        } else {
            log.info("--- getDatafile NULL");
        }
        return new JSONObject(datas);

    }

}
