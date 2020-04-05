package com.kackan.springboot_thymeleaf.service;

import com.kackan.springboot_thymeleaf.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    List<Car> cars;

    public CarServiceImpl()
    {
        cars=new ArrayList<>();
        cars.add(new Car(1L,"Ford","Mustang"));
        cars.add(new Car(2L,"Cprvette","Spider"));
        cars.add(new Car(3L,"Dacia","Sandero"));
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(Long id) {
        Car car =cars.stream().filter(c->c.getId().equals(id)).findFirst().get();
        return car;
    }

    @Override
    public void deleteCar(Long id)
    {
        Car car= cars.stream().filter(c->c.getId().equals(id)).findFirst().get();
        cars.remove(car);
    }

    @Override
    public void updateCar(Car car)
    {
        Car oldCar=cars.stream().filter(c->c.getId().equals(car.getId())).findFirst().get();
        cars.remove(oldCar);
        cars.add(car);
    }

}
