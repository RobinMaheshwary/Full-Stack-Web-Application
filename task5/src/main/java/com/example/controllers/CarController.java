package com.example.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Car;
import com.example.service.CarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cars")
public class CarController  {

    @Autowired
    private CarService carService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
       
        return carService.getCarById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCarById(@PathVariable Long id,@RequestBody Car updatedCar){
        
        return carService.getCarById(id).map(car->{
                    car.setName(updatedCar.getName());
                    car.setYear(updatedCar.getYear());
                    car.setSellingPrice(updatedCar.getSellingPrice());
                    car.setKmDriver(updatedCar.getKmDriver());
                    car.setFuel(updatedCar.getFuel());
                    car.setSellerType(updatedCar.getSellerType());
                    car.setTransmission(updatedCar.getTransmission());
                    car.setOwner(updatedCar.getOwner());
                    carService.saveCar(car);
                    return ResponseEntity.ok(car);
                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id){
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/get")
    public List<Car> getAllCar(){
        return carService.getAllCars();
        
    }
    @GetMapping("/top/{n}")
    public ResponseEntity<List<Car>> getTopNCars(@PathVariable int n) {
        List<Car> cars = carService.getTopNCars(n);
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/save")
    public ResponseEntity<Car> SaveCar(@RequestBody Car car) {
        Car obj = carService.saveCar(car);
        return ResponseEntity.ok(obj);
    }
}
