package com.carDealership.controller;


import io.javalin.http.Handler;

public class UserController {


    public Handler getAllUsers = ctx -> {
        ctx.result("Display Users here");
    };

}
