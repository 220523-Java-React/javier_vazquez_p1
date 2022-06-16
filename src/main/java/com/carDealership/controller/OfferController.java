package com.carDealership.controller;

import io.javalin.http.Handler;

public class OfferController {

    public Handler getAllOffers = ctx -> {
        ctx.result("Get All Offers Here");
    };
}
