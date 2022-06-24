package com.carDealership.repository;

import com.carDealership.model.Car;
import com.carDealership.util.ConnectionUtility;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {

    // Create car
    @Override
    public Car create(Car car) {
        String sql = "insert into cars(make, model, type, year, color, price) values(?,?,?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, car.getMake());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getType());
            stmt.setInt(4, car.getYear());
            stmt.setString(5, car.getColor());
            stmt.setDouble(6, car.getPrice());

            int success = stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                int id = keys.getInt(1);
                if (id != 0) {
                    return car.setId(id);
                }
            }
        }
        catch(PSQLException e) {
            Car notACar = new Car();
            notACar.setMake("NOT_CREATED");

            return notACar;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

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

        String sql = "select * from cars where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                Car car = new Car();
                    car
                        .setId(results.getLong("id"))
                        .setMake(results.getString("make"))
                        .setModel(results.getString("model"))
                        .setType(results.getString("type"))
                        .setYear(results.getInt("year"))
                        .setColor(results.getString("color"))
                        .setPrice(results.getDouble("price"));

                return car;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

    // Update car by id
    @Override
    public Car updateById(Car car, long id) {
        String sql = "update cars set make = ?, model = ?, type = ?, year = ?, color = ? , price = ? where id = ? ";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getMake());
            stmt.setString(2, car.getModel());
            stmt.setString(3, car.getType());
            stmt.setInt(4, car.getYear());
            stmt.setString(5, car.getColor());
            stmt.setDouble(6, car.getPrice());

            stmt.setLong(7, id);

            int success = stmt.executeUpdate();

            if(success != 0) {
                return getById(id);
            }
        }
        catch(PSQLException e) {
            Car notACar = new Car();
            notACar.setMake("NOT_UPDATED");

            return notACar;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

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
        String sql = "delete from cars where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            int success = stmt.executeUpdate();

            if (success != 0) {
                return new Car().setMake("DELETED_CAR");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        };

        return new Car();
    };
}
