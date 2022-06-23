package com.carDealership.controller;


import com.carDealership.model.User;
import com.carDealership.service.UserService;
import io.javalin.http.Handler;

public class UserController {

    UserService userService;

    public UserController() {
        userService = new UserService();
    };

    public UserController(UserService userService) {
        this.userService = userService;
    };

    public Handler createUser = ctx -> {

        User user = ctx.bodyAsClass(User.class);
        user = userService.createUser(user);

        if (user != null) {
            if (user.getFirstName() == "NOT_CREATED") {
                String failureMessage = "{" +
                        "\"400 error\": \"Bad Request\"," +
                        "\"message\": \"User not created. Username or email already exists.\"" +
                        "}";

                ctx.json(failureMessage).status(400);
            }
            else {
                ctx.json(user).status(201);
            }
        }
        else {
            String failureMessage = "{" +
                    "\"400 error\": \"Bad Request\"," +
                    "\"message\": \"User not created. Something went wrong. \"" +
                    "}";

            ctx.json(failureMessage).status(400);
        }

    };

    public Handler getAllUsers = ctx -> {
        ctx.json(userService.getAllUsers());
    };

    public Handler getUserById = ctx -> {

        String idParam = ctx.pathParam("id");
        Long id;

        try {
            id = Long.parseLong(idParam);
            User user = userService.getUserById(id);

            if (user != null) {
                ctx.json(user);
            }
            else {
                String failureMessage = "{" +
                        "\"404 error\": \"User Not Found\"," +
                        "\"message\": \"User with id: " + id + " not found\"," +
                        "\"message2\": \"Please enter a valid user id.\"" +
                        "}";

                ctx.json(failureMessage).status(404);
            }
        }
        catch (NumberFormatException e) {
            ctx.result("Please only enter integer values").status(400);
        };
    };

    public Handler updateUserById = ctx -> {
        long id = 0;
        userService.updateUserById(id);
        
        ctx.result("updated");
    };

//    public Handler updateUserByParams = ctx -> {
//        List<String> params = ctx.queryParams("");
//    };

    public Handler deleteUserById = ctx -> {
        String idParam = ctx.pathParam("id");
        long id = -1;

        try {
            id = Integer.parseInt(idParam);
            ctx.json(userService.deleteUserById(id));
        }
        catch (NumberFormatException e) {
            ctx.result("Please only enter integer values").status(400);
        }
        catch (NullPointerException e) {
            String failureMessage = "{" +
                    "\"404 error\": \"User with id: " + id + " not found\"," +
                    "\"message\": \"Please enter a valid user id.\"" +
                    "}";

            ctx.json(failureMessage).status(404);
        };
    };
};
