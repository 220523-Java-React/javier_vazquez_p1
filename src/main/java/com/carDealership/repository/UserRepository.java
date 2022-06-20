package com.carDealership.repository;

import com.carDealership.model.User;

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
