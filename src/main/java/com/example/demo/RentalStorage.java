package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RentalStorage {
    private List<Rental> rentalList = new ArrayList<>();

    public RentalStorage() {
        rentalList.add(new Rental(new User("123"), new Car("vw", "passat", "000", CarType.PREMIUM)));
        rentalList.add(new Rental(new User("321"), new Car("skoda", "fabia", "111", CarType.STANDARD)));
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public Rental findByVin(String vin) throws Exception {
        Optional<Rental> findRental = getRentalList().stream().filter(el -> el.getCar().getVin().equals(vin)).findFirst();
        if(findRental.isPresent()) throw new Exception("already rented");
        return findRental.get();
    }
}
