package com.example.carShop.controllers;

import com.example.carShop.dto.users.SaveUserDTO;
import com.example.carShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void saveUserRequest(@RequestBody SaveUserDTO saveUserDTO) {
        userService.saveUser(saveUserDTO);
    }

}