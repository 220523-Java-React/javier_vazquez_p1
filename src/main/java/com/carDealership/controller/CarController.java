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

        try {
            long id = Long.parseLong(idParam);
            Car car = carService.getCarById(id);

            if (car != null) {
                ctx.json(car);
            }
            else {
                String failureMessage = "{" +
                    "\"404 error\": \"Car with id: " + id + " not found\"," +
                    "\"message\": \"Please enter a valid car id.\"" +
                    "}";

                ctx.json(failureMessage).status(404);
            }
        }
        catch (NumberFormatException e) {
            String failureMessage = "{" +
                    "\"400 error\": \"Bad Request\"," +
                    "\"message\": \"Please only enter integer values.\"" +
                    "}";

            ctx.json(failureMessage).status(400);
        };
    };

    public Handler updateCarById = ctx -> {
        String idParam = ctx.pathParam("id");

        try {
            long id = Long.parseLong(idParam);

            Car car = ctx.bodyAsClass(Car.class);
            car = carService.updateCarById(car, id);

            if (car != null) {
                if (car.getMake() != "NOT_UPDATED") {
                    ctx.json(car);
                }
                else {
                    ctx.result("Not Updated");
                }
            }
            else {
                String failureMessage = "{" +
                        "\"404 error\": \"Car Not Found\"," +
                        "\"message\": \"Car with id: " + id + " not found\"," +
                        "\"message2\": \"Please enter a valid car id.\"" +
                        "}";

                ctx.json(failureMessage).status(404);
            }
        }
        catch (NumberFormatException e) {
            ctx.result("Please only enter integer values").status(400);
        };
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
