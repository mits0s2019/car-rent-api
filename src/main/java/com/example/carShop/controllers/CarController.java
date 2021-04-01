package com.example.carShop.controllers;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCarRequest(@RequestBody CarDTO carDTO){

        carService.saveCar(carDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDTO>> fetchCarsRequest() {

        return ResponseEntity.ok(carService.fetchCars());
    }
}
