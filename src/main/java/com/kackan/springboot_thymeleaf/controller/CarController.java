package com.kackan.springboot_thymeleaf.controller;

import com.kackan.springboot_thymeleaf.model.Car;
import com.kackan.springboot_thymeleaf.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model)
    {
        List<Car> cars=service.getAllCars();
        model.addAttribute("cars",cars);
        model.addAttribute("newCar",new Car());
        return "car-main";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car)
    {
        service.addCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/update-car/{id}")
    public String updateCar(@PathVariable Long id,Model model)
    {
        Car carToUpdate=service.getCarById(id);

        System.out.println(carToUpdate.toString());
        model.addAttribute("carToUpdate",carToUpdate);
        return "car-to-update";
    }

    @PostMapping("/save-updated-car")
    public String saveUpdatedCar(@ModelAttribute Car carToUpdate)
    {
        service.updateCar(carToUpdate);
        return "redirect:/cars";
    }

    @GetMapping("/delete-car/{id}")
    public String removeCar(@PathVariable Long id)
    {
        service.deleteCar(id);
        return "redirect:/cars";
    }

}
