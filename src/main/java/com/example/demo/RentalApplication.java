package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@SpringBootApplication
public class RentalApplication {

    private final CarService carService;

    public RentalApplication(CarService carService) throws Exception {
        this.carService = carService;

        System.out.println(carService.getAllRentals());

        User testUser = new User("123");

        System.out.println("test");
        RentalInfo rentalInfo = carService.rentCar(testUser, "123", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 13));
        System.out.println(rentalInfo.getPrice());
        System.out.println(carService.getAllRentals());
    }


    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }
}
