package com.carDealership.repository;

import com.carDealership.model.Car;
import com.carDealership.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {

    // Create car
    @Override
    public Car create(Car car) {
//        if(cars.add(car)) {
//            return car;
//        }
        return null;
    };

    // Get all cars
    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();

        String sql = "select * from cars";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                cars.add(
                    new Car()
                            .setId(results.getLong("id"))
                            .setMake(results.getString("make"))
                            .setModel(results.getString("model"))
                            .setType(results.getString("type"))
                            .setYear(results.getInt("year"))
                            .setColor(results.getString("color"))
                            .setPrice(results.getDouble("price"))
                );
            };
        }
        catch (SQLException e) {
            return null;
        };

        return cars;
    };

    // Get car by id
    @Override
    public Car getById(long id) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == id) {
//                return cars.get(i);
//            }
//        }
        return null;
    };

    // Update car by id
    @Override
    public Car updateById(Car car, long id) {
        return null;
    };

//    // Update car by params
//    @Override
//    public Car updateById(long id) {
//        return car;
//    };

    // Delete car by id
    @Override
    public Car deleteById(long id) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == id) {
//                cars.get(i).setColor("ERASED");
//                cars.get(i).setMake("ERASED");
//                cars.get(i).setModel("ERASED");
//                return cars.get(i);
//            }
//        }
        return null;
    };
}
