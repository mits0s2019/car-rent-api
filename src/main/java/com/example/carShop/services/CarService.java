package com.example.carShop.services;

import com.example.carShop.models.dto.requests.SaveCarDTO;
import com.example.carShop.models.persistence.Car;
import com.example.carShop.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {


    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    public void saveCar(SaveCarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        carRepository.save(car);
    }
}
