package com.kackan.springboot_thymeleaf.service;

import com.kackan.springboot_thymeleaf.model.Car;

import java.util.List;

public interface CarService {

    void addCar(Car car);

     List<Car> getAllCars();

     Car getCarById(Long id);

     void deleteCar(Long id);

     void updateCar(Car car);
}
