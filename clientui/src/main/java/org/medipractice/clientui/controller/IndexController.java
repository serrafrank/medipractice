package org.medipractice.clientui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController  extends AbstractController {

    @Value("${pager.homepage.index:'/'}")
    private String homepage;

    @PostMapping(value = "/setDatafile")
    public RedirectView setDatafiles(@RequestParam(name = "datafileId") String datafileId, HttpSession httpSession) {
        httpSession.setAttribute(HTTPSESSION_DATAFILE, datafileId);
        return new RedirectView(homepage);
    }
}
