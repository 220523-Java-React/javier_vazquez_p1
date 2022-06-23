package com.carDealership.controller;

import com.carDealership.model.Car;
import com.carDealership.service.CarService;
import io.javalin.http.Handler;

public class CarController {

    CarService carService;

    public CarController() {
        carService = new CarService();
    };

    public CarController(CarService carService) {
        this.carService = carService;
    };

    public Handler createCar = ctx -> {

        Car car = ctx.bodyAsClass(Car.class);
        carService.createCar(car);

        ctx.json(car).status(201);
    };

    public Handler getAllCars = ctx -> {

        ctx.json(carService.getAllCars());
    };

    public Handler getCarById = ctx -> {

        String idParam = ctx.pathParam("id");
        long id = -1;

        try {
            id = Integer.parseInt(idParam);
            ctx.json(carService.getCarById(id));
        }
        catch (NumberFormatException e) {
            ctx.result("Please only enter integer values").status(400);
        }
        catch (NullPointerException e) {

            String failureMessage = "{" +
                    "\"404 error\": \"Car with id: " + id + " not found\"," +
                    "\"message\": \"Please enter a valid car id.\"" +
                    "}";

            ctx.json(failureMessage).status(404);
        };
    };

    public Handler updateCarById = ctx -> {
        long id = 0;

        carService.updateCarById(id);
        ctx.result("updated");
    };

//    public Handler updateCarByParams = ctx -> {
//        List<String> params = ctx.queryParams("");
//    };

    public Handler deleteCarById = ctx -> {
        String idParam = ctx.pathParam("id");
        long id = -1;

        try {
            id = Integer.parseInt(idParam);
            ctx.json(carService.deleteCarById(id));
        }
        catch (NumberFormatException e) {
            ctx.result("Please only enter integer values").status(400);
        }
        catch (NullPointerException e) {

            String failureMessage = "{" +
                    "\"404 error\": \"Car with id: " + id + " not found\"," +
                    "\"message\": \"Please enter a valid car id.\"" +
                    "}";

            ctx.json(failureMessage).status(404);
        };
    };


};
