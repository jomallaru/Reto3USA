package com.example.Reto3.Controller;


import com.example.Reto3.Model.Car;
import com.example.Reto3.Service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car")

public class CarController {
    private CarService carService;

    @GetMapping("/all") // ->>>> localhost../api/Car/all
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}") // ->>>> localhost../api/Car/
    public Optional<Car> getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public  Car save(@RequestBody Car car){
        return carService.save(car);
    }
}
