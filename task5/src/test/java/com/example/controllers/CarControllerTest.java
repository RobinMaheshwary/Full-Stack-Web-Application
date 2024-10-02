package com.example.controllers;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.entity.Car;
import com.example.service.CarService;
 
@WebMvcTest(CarController.class)
public class CarControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private CarService carService;
 
    // @Autowired
    // private ObjectMapper objectMapper;
 
    @Test
    public void testGetCarById() throws Exception {
        Car car = new Car(1L, "Car A", "2021", 15000.0, 10000.0, "Petrol", "Dealer", "Manual", "First");
        when(carService.getCarById(1L)).thenReturn(Optional.of(car));
 
        mockMvc.perform(get("/cars/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(1)))
               .andExpect(jsonPath("$.name", is("Car A")))
               .andExpect(jsonPath("$.year", is("2021")));
    }
 
    // @Test
    // public void testUpdateCarById() throws Exception {
    //     Car existingCar = new Car(1L, "Car A", "2021", 15000.0, 10000.0, "Petrol", "Dealer", "Manual", "First");
    //     Car updatedCar = new Car(1L, "Car B", "2022", 18000.0, 5000.0, "Diesel", "Individual", "Automatic", "Second");
 
    //     when(carService.getCarById(1L)).thenReturn(Optional.of(existingCar));
    //     when(carService.saveCar(any((Car.class)))).thenReturn(updatedCar);
 
    //     mockMvc.perform(put("/cars/1")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(updatedCar)))
    //            .andExpect(status().isOk())
    //            .andExpect(jsonPath("$.name", is("Car B")))
    //            .andExpect(jsonPath("$.year", is("2022")));
    // }
 
    @Test
    public void testDeleteCarById() throws Exception {
        doNothing().when(carService).deleteCarById(1L);
 
        mockMvc.perform(delete("/cars/1"))
               .andExpect(status().isNoContent());
    }
 
    @Test
    public void testGetAllCar() throws Exception {
        List<Car> cars = Arrays.asList(
            new Car(1L, "Car A", "2021", 15000.0, 10000.0, "Petrol", "Dealer", "Manual", "First"),
            new Car(2L, "Car B", "2022", 18000.0, 5000.0, "Diesel", "Individual", "Automatic", "Second")
        );
 
        when(carService.getAllCars()).thenReturn(cars);
 
        mockMvc.perform(get("/cars/"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.size()", is(2)))
               .andExpect(jsonPath("$[0].name", is("Car A")))
               .andExpect(jsonPath("$[1].name", is("Car B")));
    }
 
    @Test
    public void testGetTopNCars() throws Exception {
        List<Car> cars = Arrays.asList(
            new Car(1L, "Car A", "2021", 15000.0, 10000.0, "Petrol", "Dealer", "Manual", "First"),
            new Car(2L, "Car B", "2022", 18000.0, 5000.0, "Diesel", "Individual", "Automatic", "Second")
        );
 
        when(carService.getTopNCars(2)).thenReturn(cars);
 
        mockMvc.perform(get("/cars/top/2"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.size()", is(2)))
               .andExpect(jsonPath("$[0].name", is("Car A")))
               .andExpect(jsonPath("$[1].name", is("Car B")));
    }
}
