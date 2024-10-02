package com.example.service;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
 
import com.example.entity.Car;
import com.example.repository.CarRepository;
 
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
 
    @InjectMocks
    private CarService carService;
 
    @Mock
    private CarRepository carRepository;
 
    private Car car1;
    private Car car2;
 
    @BeforeEach
    void setUp(){
        car1 = Car.builder().id(1L).name("Car A").year("2021").sellingPrice(15000.0).kmDriver(10000.0).fuel("Petrol").sellerType("Dealer").transmission("Manual").owner("First").build();
        car2 = Car.builder().id(2L).name("Car B").year("2020").sellingPrice(18000.0).kmDriver(8000.0).fuel("Diesel").sellerType("Individual").transmission("Automatic").owner("First").build();
 
    }
 
    @Test
    void testDeleteCarById() {
        doNothing().when(carRepository).deleteById(anyLong());
        carService.deleteCarById(1L);
        verify(carRepository,times(1)).deleteById(1L);
 
    }
 
    @Test
    void testGetAllCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        when(carRepository.findAll()).thenReturn(carList);
        List<Car> cars = carService.getAllCars();
        assertEquals(2,cars.size() );
        verify(carRepository,times(1)).findAll();
    }
 
    @Test
    void testGetCarById() {
        when(carRepository.findById(anyLong())).thenReturn(Optional.of(car1));
        Optional<Car> foundCar = carService.getCarById(1L);
        assertTrue(foundCar.isPresent());
        assertEquals(car1, foundCar.get());
        verify(carRepository, times(1)).findById(1L);
    }
 
    @Test
    void testGetTopNCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        when(carRepository.findAll()).thenReturn(carList);
        List<Car> topCars = carService.getTopNCars(1);
        assertEquals(1, topCars.size());
        assertEquals(car2, topCars.get(0));
        verify(carRepository,times(1)).findAll();
    }
 
    @Test
    void testSaveCar() {
        when(carRepository.save(any(Car.class))).thenReturn(car1);
        Car savedCar = carService.saveCar(car1);
        assertEquals(car1, savedCar);
        verify(carRepository, times(1)).save(car1);
    }
    
    // Test case for checking file location
}
 