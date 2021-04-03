package com.example.carShop.dto.users;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SaveUserDTO {

    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "first name is mandatory")
    private String firstName;
    @NotBlank(message = "last name is mandatory")
    private String lastName;
    @NotBlank(message = "email is mandatory")
    private String email;
}
