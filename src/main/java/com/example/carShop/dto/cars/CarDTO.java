package com.example.carShop.dto.cars;

import com.example.carShop.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO extends BaseDTO {

    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @Positive
    private double price;
    private String url;
}
