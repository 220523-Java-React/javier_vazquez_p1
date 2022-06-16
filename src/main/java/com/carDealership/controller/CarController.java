package com.carDealership.controller;

import io.javalin.http.Handler;

public class CarController {

    public Handler getAllCars = ctx -> {
        ctx.result("Get All Cars Here");
    };
}
