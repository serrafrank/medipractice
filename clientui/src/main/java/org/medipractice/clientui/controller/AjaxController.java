package org.medipractice.clientui.controller;

import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxy.PageProxy;
import org.medipractice.clientui.service.DataService;
import org.medipractice.clientui.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class AjaxController {


    @Autowired
    private PageService pageService;

    @Autowired
    private DataService dataService;

    @PostMapping(value = "/page")
    public ResponseEntity<?> postIndex(@RequestBody PageBean page) {
        return pageService.postPage(page);
    }


    @PostMapping("/page/{module}/{name}/submission")
    public DataFileDto postDataFile( @Valid @RequestBody DataFileDto datafile) {

        return this.dataService.postDatas(datafile);

    }


}
