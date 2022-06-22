package com.carDealership.model;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Role role;

    public User(){};

//    public User(int id, String firstName, String lastName, String username, String password, String email, Role role) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.role = role;
//    };

    public long getId() {
        return id;
    };

    public User setId(int id) {
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
}

enum Role {
    MANAGER("MANAGER"),
    SALESMAN("SALESMAN"),
    BUYER("BUYER");

    final String value;

    Role(String value) {
        this.value = value;
    };
};
