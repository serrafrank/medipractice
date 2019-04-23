package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.UserAccountBean;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
public abstract class AbstractController {

    protected final static String HTTPSESSION_DATAFILE = "datafile_id";

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

        if (httpSession.getAttribute(HTTPSESSION_DATAFILE) != null) {
            String datafile_id = (String) httpSession.getAttribute(HTTPSESSION_DATAFILE);
            UUID datafileId = UUID.fromString(datafile_id);
            List<DataFileBean> dataFile = this.serviceManager.getDataService().getDatas(datafileId);

            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));

        }
        return new JSONObject(datas);

    }

    @ModelAttribute("disabledMenu")
    private Boolean isDisabled(HttpSession httpSession){
        return (httpSession.getAttribute(HTTPSESSION_DATAFILE) == null);
    }

}
