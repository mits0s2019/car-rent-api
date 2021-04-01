package com.example.carShop.dto.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @Positive
    private double price;
    private String url;
}
