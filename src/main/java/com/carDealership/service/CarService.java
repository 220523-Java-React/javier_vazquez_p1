package com.carDealership.service;

import com.carDealership.model.Car;
import com.carDealership.repository.CarRepository;

import java.util.List;

public class CarService {

    CarRepository carRepository;

    public CarService() {
        carRepository = new CarRepository();
    };

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    };

    public Car createCar(Car car) {
        return carRepository.create(car);
    };

    public List<Car> getAllCars() {
        return carRepository.getAll();
    };

    public Car getCarById(long id) {
        return carRepository.getById(id);
    };

    public Car updateCarById(long id) {
        return carRepository.updateById(id);
    };
//    public Car updateCarByParams(Car car, List<String> params) {
//        return carRepository.updateByParams(car, params);
//    };

    public Car deleteCarById(long id) {
        return carRepository.deleteById(id);
    };
};
