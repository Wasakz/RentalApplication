package com.example.demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void getAllRentals() {
    }

    @Test
    void getAllCars() {
    }

    @Test
    void shouldCalculateRentPrice() throws Exception {
        //given
        User testUser = new User("123");
        CarStorage carStorage = new CarStorage();
        RentalStorage rentalStorage = new RentalStorage();
        CarService carService = new CarService(carStorage, rentalStorage);

        //when
        RentalInfo rentalInfo = carService.rentCar(testUser, "123", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 13));

        //then
        assertEquals(300, rentalInfo.getPrice());
    }

    @Test
    void shouldThrowAlreadyRentedException() throws Exception {
        //given
        User testUser = new User("123");
        CarStorage carStorage = new CarStorage();
        RentalStorage rentalStorage = new RentalStorage();
        CarService carService = new CarService(carStorage, rentalStorage);

        //when
        carService.rentCar(testUser, "123", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 13));
        Exception carException = assertThrows(Exception.class, () -> carService.rentCar(testUser, "123", LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 13)));

        //then
        assertEquals("already rented", carException.getMessage());
    }

    @Test
    void shouldThrowNoCarException() throws Exception {
        //given
        User testUser = new User("123");
        CarStorage carStorage = new CarStorage();
        RentalStorage rentalStorage = new RentalStorage();
        CarService carService = new CarService(carStorage, rentalStorage);

        //when
        Exception carException = assertThrows(Exception.class, () -> carService.rentCar(testUser, null, LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 13)));

        //then
        assertEquals("no car", carException.getMessage());
    }
}