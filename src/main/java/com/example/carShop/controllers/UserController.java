package com.example.carShop.controllers;

import com.example.carShop.dto.users.UserDTO;
import com.example.carShop.mappers.UserMapper;
import com.example.carShop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userMapper.mapToListDTO(userService.getUsers());
    }
}
