package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Car;
import com.example.repository.CarRepository;



@Service
public class CarService{

    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public Optional<Car> getCarById(Long id){
        return carRepository.findById(id);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

    public List<Car> getTopNCars(int n){
        return carRepository.findAll().stream().sorted((car1,car2)->car2.getSellingPrice().compareTo(car1.getSellingPrice())).limit(n).toList();
    }
}