package org.medipractice.pageserver.controller;

import org.medipractice.pageserver.model.Page;
import org.medipractice.pageserver.service.PageService;
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

    @GetMapping(value = "{name}")
    public Page getPage(@PathVariable String name) {
        return pageService.findByName(name);

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
