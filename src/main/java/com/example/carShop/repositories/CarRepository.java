package com.example.carShop.repositories;

import com.example.carShop.dto.cars.CarDTO;
import com.example.carShop.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT new com.example.carShop.dto.cars.CarDTO(c.brand, c.price, c.url) FROM Car c")
    List<CarDTO> fetchCars();
}
