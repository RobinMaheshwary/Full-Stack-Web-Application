package com.example.loaders;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.entity.Car;
import com.example.service.CarService;

@Component
public class LoadingCSV implements CommandLineRunner{

    @Autowired
    private CarService carService;


    @Override
    public void run(String... args) throws Exception {
        if (carService.getAllCars().isEmpty()) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new ClassPathResource("CAR_DETAILS_DATA.csv").getInputStream()));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
 
                Car car = new Car(null, fields[0], fields[1], Double.valueOf(fields[2]), Double.valueOf(fields[3]),
                        fields[4], fields[5], fields[6], fields[7]);
                carService.saveCar(car);
            }
            System.out.println("DATA UPLOADED");
        }else{
            System.out.println("Data already Present");
        }
    }
}
