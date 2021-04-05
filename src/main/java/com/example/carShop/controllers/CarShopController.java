package com.example.carShop.controllers;

import com.example.carShop.dto.users.UserDTO;
import com.intersalonica.security.dto.UserDetailsDTO;
import com.intersalonica.security.entity.AuthUser;
import com.intersalonica.security.entity.Role;
import com.intersalonica.security.repository.AuthUserRepository;
import com.intersalonica.security.repository.PrivilegeRepository;
import com.intersalonica.security.repository.RoleRepository;
import com.intersalonica.security.service.InterSecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
public class CarShopController {

    private final InterSecurityService interSecurityService;
    private final AuthUserRepository authUserRepository;
    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @RequestMapping("/login")
    public UserDetailsDTO userLogin(@RequestBody UserDTO userDTO, HttpServletResponse response) {
        interSecurityService.userAuthentication(userDTO.getUsername(), userDTO.getPassword(), response);
        return interSecurityService.getUserDetailsDTO(userDTO.getUsername());
    }

    @GetMapping
    @RequestMapping("/logout")
    public void userLogout(HttpServletResponse response) {
        interSecurityService.setLogoutSuccessHeader(response);
    }

    @PostMapping
    @RequestMapping("/register")
    public void userRegister(@RequestBody UserDTO userDTO) {
        AuthUser authUser = new AuthUser();
        authUser.setUsername(userDTO.getUsername());
        authUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> roles = new HashSet();
        roles.add(role);

        authUser.setRoles(roles);

        this.authUserRepository.save(authUser);
    }

}