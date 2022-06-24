package com.carDealership.model;

import java.util.Objects;

public class Car {

    private long id;
    private String make;
    private String model;
    private String type;
    private int year;
    private String color;
    private double price;
    private CarSold carsold;

    public Car() {};

    public Car(long id, String make, String model, String type, int year, String color, double price, CarSold carsold) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.color = color;
        this.price = price;
        this.carsold = carsold;
    }

    public long getId() {
        return id;
    };

    public Car setId(long id) {
       this.id = id;
       return this;
    };

    public String getMake() {
        return make;
    };

    public Car setMake(String make) {
        this.make = make;
        return this;
    };

    public String getModel() {
        return model;
    };

    public Car setModel(String model) {
        this.model = model;
        return this;
    };

    public String getType() {
        return type;
    };

    public Car setType(String type) {
        this.type = type;
        return this;
    };

    public int getYear() {
        return year;
    };

    public Car setYear(int year) {
        this.year = year;
        return this;
    };

    public String getColor() {
        return color;
    };

    public Car setColor(String color) {
        this.color = color;
        return this;
    };

    public double getPrice() {
        return price;
    };

    public Car setPrice(double price) {
        this.price = price;
        return this;
    };

    public CarSold getCarSold() {
        return carsold;
    };

    public Car setCarSold(CarSold carsold) {
        this.carsold = carsold;
        return this;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && year == car.year && Double.compare(car.price, price) == 0 && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(type, car.type) && Objects.equals(color, car.color) && carsold == car.carsold;
    };

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, type, year, color, price, carsold);
    };

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", carsold=" + carsold +
                '}';
    };
};
