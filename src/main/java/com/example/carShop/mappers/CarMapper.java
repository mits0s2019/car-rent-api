package com.example.carShop.mappers;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.models.Car;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper {

    CarDTO mapToDTO(Car car);

    Car mapToEntity(CarDTO car);

    List<CarDTO> mapToListDTO(List<Car> cars);
}
