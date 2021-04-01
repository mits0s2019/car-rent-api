package com.example.carShop.models.dto.responses;

import com.example.carShop.models.persistence.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarListDTO {
    private List<Car> cars;
}
