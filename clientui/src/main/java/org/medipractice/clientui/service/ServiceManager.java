package org.medipractice.clientui.service;

import lombok.Data;
import org.medipractice.clientui.service.contract.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ServiceManager {

    @Autowired
    private AuthService authService;

    @Autowired
    private DataService dataService;

    @Autowired
    private PageService pageService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;
}
