package org.medipractice.pageserver.controller;

import org.medipractice.pageserver.model.Menu;
import org.medipractice.pageserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/navigation")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> findAll() {
        return menuService.findAll();

    }

    @PostMapping
    public ResponseEntity<Void> postNavigation(
            @RequestBody Menu navigation
    ) {
        menuService.save(navigation);
        return ResponseEntity.ok().build();
    }

}