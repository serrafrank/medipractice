package org.medipractice.authserver.controller;

import org.medipractice.authserver.business.UserBusiness;
import org.medipractice.authserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    protected UserBusiness userBusiness;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public User getCurrentCustomer(Principal principal) {
        return userBusiness.getByUsername(principal.getName());
    }


    @GetMapping(value = "/all")
    public List<User> getCustomers() {
        return userBusiness.findAll();
    }


    @GetMapping(value = "/{id}")
    public User getCustomer(
            @PathVariable("id") Integer id) {

        return userBusiness.getById(id);
    }


    @PostMapping
    public ResponseEntity<?> postCustomer(
            @Valid @RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User customerAdded = userBusiness.save(user);

        String path = "/{id}";

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(customerAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();



    }

    @PutMapping
    public ResponseEntity<String> update(
            @Valid @RequestBody User user) {

        userBusiness.update(user);

        // Return the HTTP SUCCESS CODE
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id) {
        userBusiness.delete(id);
        return ResponseEntity.ok().build();
    }
}
