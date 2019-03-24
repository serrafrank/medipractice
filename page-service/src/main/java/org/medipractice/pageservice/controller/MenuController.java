package org.medipractice.pageservice.controller;

import org.medipractice.pageservice.model.Module;
import org.medipractice.pageservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Module> findAll() {
        return menuService.findAll();

    }

    @PostMapping
    public ResponseEntity<?> postNavigation(
            @RequestBody Module navigation
    ) {
        menuService.save(navigation);
        return ResponseEntity.ok().build();
    }

}
