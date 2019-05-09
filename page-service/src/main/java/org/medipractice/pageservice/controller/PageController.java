package org.medipractice.pageservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.medipractice.pageservice.model.Page;
import org.medipractice.pageservice.model.components.Schema;
import org.medipractice.pageservice.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("page")
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping
    public Page getIndex() {
        return pageService.findByName("homepage", "index");

    }

    @GetMapping(value = "/{module}/{name}")
    public Page getPage(@PathVariable String module, @PathVariable String name) {
        return pageService.findByName(module, name);

    }

    @PostMapping
    public ResponseEntity<?> postPage(  @RequestBody Page page ) throws JsonProcessingException {

        page = pageService.save(page);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand("0")
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
