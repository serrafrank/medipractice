package org.medipractice.clientui.controller;

import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxies.PageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AjaxController {

    @Autowired
    private PageProxy pageProxy;

    @PostMapping(value = "/page")
    public ResponseEntity<?> postIndex(@RequestBody PageBean page, HttpSession httpSession) {
        return pageProxy.postPage(httpSession.getAttribute("token").toString(), page);
    }

}
