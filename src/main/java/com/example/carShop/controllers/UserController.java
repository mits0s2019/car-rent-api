package com.example.carShop.controllers;

import com.example.carShop.dto.users.SaveUserDTO;
import com.example.carShop.dto.users.UserDTO;
import com.example.carShop.mappers.UserMapper;
import com.example.carShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public void saveUserRequest(@RequestBody SaveUserDTO saveUserDTO) {
        userService.saveUser(saveUserDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userMapper.mapToListDTO(userService.getUsers());
    }
}
