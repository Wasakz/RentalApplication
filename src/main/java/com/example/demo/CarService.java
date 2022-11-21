package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;

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

    public void rentCar(User user, String vin) {
        Optional<Car> findCar = getAllCars().stream().filter(el -> el.getVin().equals(vin)).findFirst();
        if (findCar.isPresent() && !findCar.get().isRented()) {
            findCar.get().setRented(true);
            this.rentalStorage.addRental(findCar.get(), user);
        }
    }
}
