package com.example.repository;
 
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
 
import com.example.entity.Car;
 
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CarRepositoryTest {
   
    @Autowired
    private CarRepository carRepository;
 
    @Test
    public void testFindById(){
        Car car = Car.builder().name("Test Car").year("2022").sellingPrice(20000.0).kmDriver(5000.0).fuel("Petrol").sellerType("Dealer").transmission("Automatic").owner("First").build();
 
        Car savedCar = carRepository.save(car);
        Optional<Car> foundCar = carRepository.findById(savedCar.getId());
        assertTrue(foundCar.isPresent());
        assertEquals(savedCar.getId(), foundCar.get().getId());
    }
 
    @Test
    public void testFindAll(){
        Car car1 = Car.builder().name("Car 1").year("2022").sellingPrice(25000.0).kmDriver(1000.0).fuel("Petrol").sellerType("Dealer").transmission("Automatic").owner("First").build();
 
        Car car2 = Car.builder().name("Car 2").year("2021").sellingPrice(15000.0).kmDriver(15000.0).fuel("Diesel").sellerType("Individual").transmission("Manual").owner("Second").build();
 
        carRepository.save(car1);
        carRepository.save(car2);
 
        List<Car> cars = carRepository.findAll();
        assertEquals(2, cars.size());
    }
 
    @Test
    public void testDeleteCarById(){
        Car car = Car.builder().name("Test car").year("2022").sellingPrice(20000.0).kmDriver(5000.0).fuel("Petrol").sellerType("Dealer").transmission("Automatic").owner("First").build();
 
        Car saveCar = carRepository.save(car);
        carRepository.deleteById(saveCar.getId());
        Optional<Car> deletedCar = carRepository.findById(saveCar.getId());
        assertTrue(deletedCar.isEmpty());
    }
}