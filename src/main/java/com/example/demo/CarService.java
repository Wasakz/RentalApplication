package com.example.demo;

import org.springframework.cglib.core.Constants;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;

    private final int BASE_PRICE = 100;

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentalList();
    }

    public CarService(CarStorage carStorage, RentalStorage rentalStorage) {
        this.carStorage = carStorage;
        this.rentalStorage = rentalStorage;
    }

    public List<Car> getAllCars() {
        return carStorage.getCarList();
    }

    private long calculatePrice(int basePrice, LocalDate from, LocalDate to, CarType carType) {
        long daysBetween = DAYS.between(from, to); // Chrono units days beetween
        long carMultiplier = 1;
        switch (carType) {
            case PREMIUM -> carMultiplier = 2;
            case BLAZINGLY_FAST -> carMultiplier = 4;
        }
        return daysBetween * basePrice * carMultiplier;
    }

    public RentalInfo rentCar(User user, String vin, LocalDate from, LocalDate to) throws Exception {
        Optional<Car> findCar = getAllCars().stream().filter(el -> el.getVin().equals(vin)).findFirst();
        if(findCar.isEmpty()) throw new Exception("no car");

        Optional<Rental> findRental = getAllRentals().stream().filter(el -> el.getCar().getVin().equals(vin)).findFirst();

        if(findRental.isPresent()) throw new Exception("already rented");
        Rental newRental = new Rental(user, findCar.get());
        this.rentalStorage.addRental(newRental);
        CarType carType = newRental.getCar().getCarType();
        return new RentalInfo(calculatePrice(BASE_PRICE, from, to, carType), from, to);
    }

    //testy przypadki
    // vin jest null
    // czy istnieje samochod, czy jest wypozyczony
    // obliczenie ceny
}
