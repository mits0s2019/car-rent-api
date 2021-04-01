package com.example.carShop.constrollers;

import com.example.carShop.models.dto.requests.SaveCarDTO;
import com.example.carShop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCar(@RequestBody SaveCarDTO saveCarDTO) {

        carService.saveCar(saveCarDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
