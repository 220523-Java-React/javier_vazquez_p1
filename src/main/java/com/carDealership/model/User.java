package com.carDealership.model;

import java.util.Objects;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Role role;

    public User(){};

    public User(int id, String firstName, String lastName, String username, String password, String email, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    };

    public long getId() {
        return id;
    };

    public User setId(long id) {
        this.id = id;
        return this;
    };

    public String getFirstName() {
        return firstName;
    };

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    };

    public String getLastName() {
        return lastName;
    };

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    };

    public String getUsername() {
        return username;
    };

    public User setUsername(String username) {
        this.username = username;
        return this;
    };

    public String getPassword() {
        return password;
    };

    public User setPassword(String password) {
        this.password = password;
        return this;
    };

    public String getEmail() {
        return email;
    };

    public User setEmail(String email) {
        this.email = email;
        return this;
    };

    public Role getRole() {
        return role;
    };

    public User setRole(Role role) {
        this.role = role;
        return this;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && role == user.role;
    };

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, email, role);
    };

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    };
};


