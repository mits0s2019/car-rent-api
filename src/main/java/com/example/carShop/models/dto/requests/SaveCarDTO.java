package com.example.carShop.models.dto.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
public class SaveCarDTO {

    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @Positive
    private double price;
    private String url;
}
