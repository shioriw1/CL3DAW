package com.DAW3.LozanoHuaihuaAlexis.ExamenT3.controller;


import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.dto.CarDTO;
import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.entity.Car;
import com.DAW3.LozanoHuaihuaAlexis.ExamenT3.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<CarDTO> getCars(){
        List<CarDTO> cars = carService.getAllCar();
        return cars;
    }
    @GetMapping("/cars/{id}")
    public CarDTO getCarDetails(@PathVariable Integer id, Model model) {
        CarDTO car = carService.getCarDetails(id);
        model.addAttribute("car", car);
        return car;
    }
    @PutMapping("/cars/{id}")
    public String updateCar(@PathVariable Integer id, @RequestBody Car car) {
        carService.updateCar(id, car);
        return "se actualizo los detalles del carro";
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return "se elimino el registro : " + id;
    }

    @PostMapping("/cars")
    public String createCar(@RequestBody Car car) {
        carService.createCar(car);
        return "Se creo nuevo registro";
    }
}
