package com.example.carShop.dto.users;

import com.example.carShop.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String username;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String confirmationPassword;
    private String firstName;
    private String lastName;
    private String email;
}
