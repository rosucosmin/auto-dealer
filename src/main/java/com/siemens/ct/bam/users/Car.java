package com.siemens.ct.bam.users;

import java.util.Objects;

public class Car {
    private String plateNumber;
    private String brand;
    private String colour;

    public Car(String plateNumber, String brand, String colour) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.colour = colour;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber: " + plateNumber + ' ' +
                ", brand: " + brand + ' ' +
                ", colour: " + colour + ' ' + '}';
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        return Objects.equals(plateNumber, car.plateNumber) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(colour, car.colour);
    }

}
