package com.carDealership.repository;

import com.carDealership.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {

    private List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    };

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }

    // Create car
    @Override
    public Car create(Car car) {
        if(cars.add(car)) {
            return car;
        }
        return null;
    };

    // Get all cars
    @Override
    public List<Car> getAll() {
        return cars;
    };

    // Get car by id
    @Override
    public Car getById(long id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                return cars.get(i);
            }
        }
        return null;
    };

    // Update car by params
    @Override
    public Car updateByParams(Car car, List<String> params) {
        return car;
    };

    // Delete car by id
    @Override
    public Car deleteById(long id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                cars.get(i).setColor("ERASED");
                cars.get(i).setMake("ERASED");
                cars.get(i).setModel("ERASED");
                return cars.get(i);
            }
        }
        return null;
    };
}
