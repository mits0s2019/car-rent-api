package com.example.carShop.controllers;

import com.example.carShop.models.User;
import com.example.carShop.services.UserService;
import lombok.AllArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<User> getUsers(@And({
            @Spec(path = "firstName", params = "firstname", spec = Like.class),
            @Spec(path = "lastName", params = "lastname", spec = Like.class),
            @Spec(path = "username", spec = Like.class)
    }) Specification<User> userSpecification, Pageable pageable) {

        return userService.getUsers(pageable, userSpecification);
    }
}
