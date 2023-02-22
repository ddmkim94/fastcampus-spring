package org.example.annotation.controller;

import org.example.annotation.Controller;
import org.example.annotation.Inject;
import org.example.annotation.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
