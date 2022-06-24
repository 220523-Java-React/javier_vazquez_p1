package com.carDealership.model;

import java.util.ArrayList;
import java.util.Objects;

public class DealerLot {
    private int id;
    private ArrayList<Car> cars;

    public DealerLot() {};

    public DealerLot(ArrayList<Car> cars) {
        this.cars = cars;
    };

    public int getId() {
        return id;
    };

    public DealerLot setId(int id) {
        this.id = id;
        return this;
    };

    public ArrayList<Car> getCars() {
        return cars;
    };

    public DealerLot setCars(ArrayList<Car> cars) {
        this.cars = cars;
        return this;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealerLot dealerLot = (DealerLot) o;
        return id == dealerLot.id && Objects.equals(cars, dealerLot.cars);
    };

    @Override
    public int hashCode() {
        return Objects.hash(id, cars);
    };

    @Override
    public String toString() {
        return "DealerLot{" +
                "id=" + id +
                ", cars=" + cars +
                '}';
    };
};
