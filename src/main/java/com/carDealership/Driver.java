package com.carDealership;

import com.carDealership.controller.UserController;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        UserController userController = new UserController();

        app.get("/", ctx -> ctx.result("Hello Welcome to Javy's Dealership"));
        app.get("/user", userController.getAllUsers);
    }
}
