package org.medipractice.pageserver.controller;

import org.medipractice.pageserver.model.Navigation;
import org.medipractice.pageserver.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/navigation")
public class NavigationController {

    private final NavigationService navigationService;

    @Autowired
    public NavigationController(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @GetMapping
    public List<Navigation> findAll() {
        return navigationService.findAllNavigation();

    }

    @PostMapping
    public ResponseEntity<Void> postNavigation(
            @RequestBody Navigation navigation
    ) {
        navigationService.save(navigation);
        return ResponseEntity.ok().build();
    }

}