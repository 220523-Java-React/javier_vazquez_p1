package com.carDealership.controller;


import io.javalin.http.Handler;

public class UserController {


    public Handler getAllUsers = ctx -> {
        ctx.result("Display Users here");
    };

//    public List<User> getAllUsers = ctx -> {
//        ctx.status(200).json({});
//    };
//
//    public User getUserById = ctx -> {
//        ctx.json();
//    };
}
