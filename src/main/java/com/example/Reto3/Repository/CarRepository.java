package com.example.Reto3.Repository;


import com.example.Reto3.Model.Car;
import com.example.Reto3.Repository.CRUD.CarCrudRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    @Autowired
    private CarCrudRespository carCrudRespository;

    public List<Car> findAll (){
        return (List<Car>) carCrudRespository.findAll();
    }

    public Optional<Car> getCar(int id){
        return carCrudRespository.findById(id);
    }

    public Car save(Car car){
        return carCrudRespository.save(car);

    }

    public void delete(Car car){
        carCrudRespository.delete(car);
    }
}
