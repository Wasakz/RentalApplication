package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalApplication {

    private final CarService carService;

    public RentalApplication(CarService carService) {
        this.carService = carService;

        System.out.println(carService.getAllCars());
        System.out.println(carService.getAllRentals());

        carService.rentCar(new User("123"), "111");
        System.out.println(carService.getAllRentals());
    }


    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }
}
