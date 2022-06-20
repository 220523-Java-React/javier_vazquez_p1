package com.carDealership;

import com.carDealership.controller.CarController;
import com.carDealership.controller.OfferController;
import com.carDealership.controller.UserController;
import io.javalin.Javalin;

public class Driver {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        UserController userController = new UserController();
        CarController carController = new CarController();
        OfferController offerController = new OfferController();

        app.get("/", ctx -> ctx.result("Hello Welcome to Javy's Luxury Auto Dealership"));

        // User routes
        app.post("/user", userController.createUser);
        app.get("/user", userController.getAllUsers);
        app.get("/user/{id}", userController.getUserById);
        app.delete("/user/{id}", userController.deleteUserById);

        // Car routes
        app.get("/car", carController.getAllCars);
        app.get("/offer", offerController.getAllOffers);

        // Offer routes


        // Dealership routes
    }
}
