package org.medipractice.clientui.controller;

import org.medipractice.clientui.beans.data.DataFileDto;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AjaxController extends AbstractController {


    @PostMapping(value = "/page")
    public ResponseEntity<?> postIndex(@RequestBody PageBean page) {
        return this.serviceManager.getPageService().postPage(page);
    }


    @PostMapping("/page/{module}/{name}/submission")
    public DataFileDto postDataFile( @Valid @RequestBody DataFileDto datafile) {
        return this.serviceManager.getDataService().postDatas(datafile);
    }


}
