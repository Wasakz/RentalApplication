package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CarStorage {
    private List<Car> carList = new ArrayList<>();

    public CarStorage() {
        carList.add(new Car("vw", "passat", "000", CarType.PREMIUM));
        carList.add(new Car("skoda", "fabia", "111", CarType.STANDARD));
        carList.add(new Car("skoda", "octavia", "123", CarType.STANDARD));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car findByVin(String vin) throws Exception {
        Optional<Car> findCar = getCarList().stream().filter(el -> el.getVin().equals(vin)).findFirst();
        if(findCar.isEmpty()) throw new Exception("no car");
        return findCar.get();
    }
}
