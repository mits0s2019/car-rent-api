package com.example.carShop.models.dto.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaveCarDTO {

    private String brand;
    private double price;
    private String url;
}
