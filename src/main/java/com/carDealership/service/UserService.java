package com.carDealership.service;

import com.carDealership.model.User;
import com.carDealership.repository.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    };

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    };

    public User createUser(User user) {
        return userRepository.create(user);
    };

    public List<User> getAllUsers() {
        return userRepository.getAll();
    };

    public User getUserById(long id) {
        return userRepository.getById(id);
    };

    public User updateUserByParams(User user, List<String> params) {
        return userRepository.updateByParams(user, params);
    };

    public User deleteUserById(long id) {
        return userRepository.deleteById(id);
    };
};
