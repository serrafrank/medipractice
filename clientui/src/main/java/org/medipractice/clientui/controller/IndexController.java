package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.data.DataFileBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Controller
public class IndexController  extends AbstractController {

    @Value("${pager.homepage.index:'/'}")
    private String homepage;

    @GetMapping(value = "/newPatient")
    public RedirectView newPatient(HttpSession httpSession){
        String id = this.serviceManager.getDataService().postNewPatient();
        httpSession.removeAttribute(HTTPSESSION_DATAFILE);
        httpSession.setAttribute(HTTPSESSION_DATAFILE, id);
        return new RedirectView(homepage);
    }

    @PostMapping(value = "/setDatafile")
    public RedirectView setDatafiles(@RequestParam(name = "datafileId") String datafileId, HttpSession httpSession) {
        httpSession.removeAttribute(HTTPSESSION_DATAFILE);
        httpSession.setAttribute(HTTPSESSION_DATAFILE, datafileId);
        return new RedirectView(homepage);
    }
}
