package com.carDealership.repository;

import com.carDealership.model.User;
import com.carDealership.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User>{

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    };

    public UserRepository(List<User> users) {
        this.users = users;
    };

    // Create user
    @Override
    public User create(User user) {
        if(users.add(user)) {
            return user;
        }
        return null;
    };

    // Get all users
    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        String sql = "select * from users";

        try (Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                users.add(
                    new User()
                            .setId(results.getInt("id"))
                            .setFirstName(results.getString("first_name"))
                            .setLastName(results.getString("last_name"))
                            .setUsername(results.getString("username"))
                            .setPassword(results.getString("password"))
                            .setEmail(results.getString("email"))
                );
            };

        }
        catch (SQLException e){
            e.printStackTrace();
        };

        return users;
    }

    // Get user by id
    @Override
    public User getById(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);
            }
        }
        return null;
    };

    // Update user by params
    @Override
    public User updateByParams(User user, List<String> params) {
        return user;
    };

    // Delete user by id
    @Override
    public User deleteById(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.get(i).setFirstName("ERASED!!!");
                users.get(i).setLastName("ERASED!!!");
                users.get(i).setEmail("ERASED!!!");
                return users.get(i);
            }
        }
        return null;
    };
}
