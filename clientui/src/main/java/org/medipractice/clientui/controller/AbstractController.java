package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.UserAccountBean;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public abstract class AbstractController {

    protected final static String HTTPSESSION_DATAFILE = "datafile_id";

    @Autowired
    protected ServiceManager serviceManager;

    @Autowired
    protected ProxyManager proxyManager;

    protected List<ModuleBean> menu = new ArrayList<>();

    @ModelAttribute("menu")
    private List<ModuleBean> getMenu() {
        return this.getMenuList();
    }

    @ModelAttribute("user")
    private UserAccountBean getUser() {
        return this.serviceManager.getUserService().getCurrentUser();
    }

    @ModelAttribute("patient_name")
    private String getDatafile(HttpSession httpSession) {

        String[] fields = {"textfield_nom_de_naissance", "textfield_prenom", "datetime_date_de_naissance"};
        Map<String, String> datas = new HashMap<>();
        String val = "";

        if (httpSession.getAttribute(HTTPSESSION_DATAFILE) != null) {
            String datafile_id = (String) httpSession.getAttribute(HTTPSESSION_DATAFILE);
            UUID datafileId = UUID.fromString(datafile_id);
            List<DataFileBean> dataFile = this.serviceManager.getDataService().getDatas(datafileId);
            dataFile.forEach(d -> datas.put(d.getType(), d.getValue()));
            if (datas.containsKey("textfield_prenom"))
                val += datas.get("textfield_prenom") + " ";
            if (datas.containsKey("textfield_nom_de_naissance"))
                val += datas.get("textfield_nom_de_naissance").toUpperCase();
            if (datas.containsKey("datetime_date_de_naissance")) {
                try {
                    Date ddn =  new SimpleDateFormat("yyyy-MM-dd").parse(datas.get("datetime_date_de_naissance").split("T")[0]);
                    val += " - né(e) le " + new SimpleDateFormat("dd/MM/yyyy").format(ddn);
                } catch (ParseException ignore) {}
            }
        }else{
            val = "Aucun dossier patient selectionné";
        }
        return val;

    }

    @ModelAttribute("readOnly")
    private Boolean readOnly(HttpSession httpSession) {
        return (httpSession.getAttribute(HTTPSESSION_DATAFILE) == null);
    }


    @ModelAttribute("moduleList")
    private List getModuleList() {
        List<Map<String, String>> moduleList = new ArrayList<>();
        this.getMenuList().forEach(m -> {
            Map<String, String> moduleMap = new HashMap<>();
            moduleMap.put("value", m.getName());
            moduleMap.put("text", m.getLabel());
            moduleList.add(moduleMap);
        });
        return moduleList;
    }


    private List<ModuleBean> getMenuList(){
        if(this.serviceManager.getTokenService().isConnected()) {
            if (this.menu.size() == 0)
                this.menu = this.serviceManager.getPageService().findMenu();
        }
        return this.menu;

    }
}
