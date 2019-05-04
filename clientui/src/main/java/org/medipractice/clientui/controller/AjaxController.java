package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
public class AjaxController extends AbstractController {

    @PostMapping(value = "/page")
    public ResponseEntity<?> postIndex(@RequestBody PageBean page) {

        log.info(page.toString());
        return this.serviceManager.getPageService().postPage(page);
    }


    @PostMapping("/page/{module}/{name}/submission")
    public DataFileDto postDataFile(@Valid @RequestBody DataFileDto datafile, HttpSession httpSession) {

        return this.serviceManager.getDataService().postDatas(datafile, httpSession.getAttribute(HTTPSESSION_DATAFILE).toString() );
    }

    @GetMapping(value = "/getDatafiles", produces = "application/json")
    public List<Map<String, Object>> getDatafiles(@RequestParam(name = "value") String value) {

        String[] fields = {"textfield_nom_de_naissance", "textfield_prenom", "datetime_date_de_naissance"};
        List<DataFileBean> dataFileBeanList = this.serviceManager.getDataService().getDatafiles(fields, value);

        Map<UUID, Map<String, String>> selected = new HashMap<>();

        dataFileBeanList.forEach(d -> {
            if (!selected.containsKey((d.getDataFile())))
                selected.put(d.getDataFile(), new HashMap<>());
            selected.get(d.getDataFile()).put(d.getType(), d.getValue());
        });

        List<Map<String, Object>> returnedList = new ArrayList<>();
        selected.forEach((k, v) -> {
                    String val = "";
                    if (v.containsKey("textfield_prenom"))
                        val += v.get("textfield_prenom") + " ";
                    if (v.containsKey("textfield_nom_de_naissance"))
                        val += v.get("textfield_nom_de_naissance").toUpperCase();
                    if (v.containsKey("datetime_date_de_naissance")) {
                        try {
                            Date ddn =  new SimpleDateFormat("yyyy-MM-dd").parse(v.get("datetime_date_de_naissance").split("T")[0]);
                            val += " - né(e) le " + new SimpleDateFormat("dd/MM/yyyy").format(ddn);
                        } catch (ParseException e) {
                            log.error(e.toString());
                        }
                    }
                    Map<String, Object> data = new HashMap<>();
                    data.put("id", k);
                    data.put("value", val);
                    returnedList.add(data);
                }
        );
        return returnedList;
    }






}
