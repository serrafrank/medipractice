package org.medipractice.pageservice.controller;

import org.medipractice.pageservice.model.Page;
import org.medipractice.pageservice.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/page")
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

    @GetMapping(value = "{module}/{name}")
    public Page getPage(@PathVariable String module, @PathVariable String name) {
        return pageService.findByName(module, name);

    }

    @PostMapping
    public ResponseEntity<Void> postPage(
            @RequestBody String name,
            @RequestBody Page Page
            ) {
        Page page = pageService.save(Page);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(page.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
