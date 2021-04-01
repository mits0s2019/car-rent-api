package com.example.carShop.services;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.models.Car;
import com.example.carShop.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    public void saveCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        carRepository.save(car);
    }

    public List<CarDTO> fetchCars() {
        return carRepository.fetchCars();
    }
}
