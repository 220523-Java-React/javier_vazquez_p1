package com.carDealership.repository;

import com.carDealership.model.Car;
import com.carDealership.model.CarSold;
import com.carDealership.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerLotRepository {
    public List<Car> getAllCarsOnLot() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from cars where car_sold_id = 0 ";

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
                        .setCarSold(CarSold.values()[results.getInt("car_sold_id")])
                );
            };
        }
        catch (SQLException e) {
            return null;
        };

        return cars;
    };
};

