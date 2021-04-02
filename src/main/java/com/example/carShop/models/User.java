package com.example.carShop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "first name is mandatory")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "last name is mandatory")
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private List<Car> cars;
}
