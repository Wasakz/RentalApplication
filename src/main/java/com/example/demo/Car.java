package com.example.demo;

public class Car {
    private String make;
    private String model;
    private String vin;
    private CarType carType;

    public Car(String make, String model, String vin, CarType carType) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.carType = carType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
