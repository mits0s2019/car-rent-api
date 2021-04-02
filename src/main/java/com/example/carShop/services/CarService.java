package com.example.carShop.services;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.mappers.CarMapper;
import com.example.carShop.models.Car;
import com.example.carShop.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public void saveCar(CarDTO carDTO) {
        Car car = carMapper.mapToEntity(carDTO);
        carRepository.save(car);
    }

    public List<CarDTO> fetchCars() {
        List<Car> cars = carRepository.findAll();
        return carMapper.mapToListDTO(cars);
    }
}
