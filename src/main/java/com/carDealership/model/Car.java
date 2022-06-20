package com.carDealership.model;

public class Car {

    private long id;
    private String make;
    private String model;
    private String trim;
    private int year;
    private int cylinders;
    private String color;
    private double price;

    public Car() {};

    public Car(int id, String make, String model, String trim, int year, int cylinders, String color, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.year = year;
        this.cylinders = cylinders;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
