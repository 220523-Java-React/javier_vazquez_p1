package com.carDealership.controller;

import com.carDealership.service.OfferService;
import io.javalin.http.Handler;

public class OfferController {
    OfferService offerService;

    public OfferController() {
        offerService = new OfferService();
    };

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    };

    public Handler getAllOffers = ctx -> {
        ctx.json(offerService.getAllOffers());
    };
}
