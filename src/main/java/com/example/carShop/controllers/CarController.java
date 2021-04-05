package com.example.carShop.controllers;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.exceptions.CarApiException;
import com.example.carShop.models.Car;
import com.example.carShop.models.User;
import com.example.carShop.services.CarService;
import com.example.carShop.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
@AllArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;
    private final UserService userService;


    @PostMapping
    public void saveCarRequest(@RequestBody CarDTO carDTO) {
        log.info("Request : Save Car");
        carService.saveCar(carDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDTO> fetchCarsRequest() {
        log.info("Request : fetch Cars");

        return carService.fetchCars();
    }

    @PostMapping(value = "/{carId}/users/{userId}")
    public void assignCarToUserRequest(@PathVariable("userId") Long userId, @PathVariable("carId") Long carId) throws CarApiException {

        User user = userService.findUserById(userId);
        Car car = carService.findCarById(carId);
        carService.assignCarToUser(user, car);
    }
}
