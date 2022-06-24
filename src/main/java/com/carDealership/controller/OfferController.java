package com.carDealership.controller;

import com.carDealership.model.Offer;
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

    public Handler createOffer = ctx -> {
        Offer offer = ctx.bodyAsClass(Offer.class);
        offer = offerService.createOffer(offer);

        if (offer != null) {
            if (offer.getOfferMaker() == -1999) {
                String failureMessage = "{" +
                        "\"400 error\": \"Bad Request\"," +
                        "\"message\": \"Offer not created.\"" +
                        "}";

                ctx.json(failureMessage).status(400);
            }
            else {
                ctx.json(offer).status(201);
            }
        }
        else {
            String failureMessage = "{" +
                    "\"400 error\": \"Bad Request\"," +
                    "\"message\": \"User offer created. Something went wrong. \"" +
                    "}";

            ctx.json(failureMessage).status(400);
        }
    };
}
