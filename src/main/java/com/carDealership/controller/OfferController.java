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

    public Handler getAllOffers = ctx -> {
        String offerMakerParam = ctx.queryParam("offerMaker");

        if (offerMakerParam == null) {
            ctx.json(offerService.getAllOffers());
        }
        else {
            try {
                long offerMaker = Long.parseLong(offerMakerParam);
                ctx.json(offerService.getOffersByOfferMaker(offerMaker));
            }
            catch (NumberFormatException e ) {
                ctx.json(offerService.getAllOffers());
            }
            catch (NullPointerException e) {
                ctx.json(offerService.getAllOffers());
            };
        }
    };

    public Handler getOfferById = ctx -> {
        String idParam = ctx.pathParam("id");

        try {
            long id = Long.parseLong(idParam);
            Offer offer = offerService.getOfferById(id);

            if (offer != null) {
                ctx.json(offer);
            }
            else {
                String failureMessage = "{" +
                        "\"404 error\": \"Offer Not Found\"," +
                        "\"message\": \"Offer with id: " + id + " not found\"," +
                        "\"message2\": \"Please enter a valid offer id.\"" +
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

    public Handler updateOfferById = ctx -> {
        String idParam = ctx.pathParam("id");

        try {
            long id = Long.parseLong(idParam);

            Offer offer = ctx.bodyAsClass(Offer.class);
            offer = offerService.updateOfferById(offer, id);

            if (offer != null) {
                if (offer.getOfferMaker() != -1999) {
                    ctx.json(offer);
                }
                else {
                    ctx.result("Not Updated");
                }
            }
            else {
                String failureMessage = "{" +
                        "\"404 error\": \"Offer Not Found\"," +
                        "\"message\": \"Offer with id: " + id + " not found\"," +
                        "\"message2\": \"Please enter a valid offer id.\"" +
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

    public Handler deleteOfferById = ctx -> {
        String idParam = ctx.pathParam("id");
        try {
            long id = Long.parseLong(idParam);

            Offer offer = offerService.getOfferById(id);
            if (offer == null) {
                String failureMessage = "{" +
                        "\"404 error\": \"Not Found\"," +
                        "\"message\": \"Offer with id: " + idParam + " not found. Please enter a valid offer id.\"," +
                        "\"message2\": \"No offer was deleted.\"" +
                        "}";

                ctx.json(failureMessage).status(404);
            }

            if (offerService.deleteOfferById(id).getOfferMaker() == -1999) {
                String deleteSuccess = "{" +
                        "\"200 status\": \"Success\"," +
                        "\"message\": \"Offer with id: " + idParam + " was successfully deleted.\"," +
                        "}";

                ctx.status(200).json(deleteSuccess);
            }
        }
        catch (NumberFormatException e) {
            String failureMessage = "{" +
                    "\"400 error\": \"Bad Request\"," +
                    "\"message\": \"Please only enter integer values.\"" +
                    "}";

            ctx.json(failureMessage).status(400);
        }
        catch(NullPointerException e) {
            String failureMessage = "{" +
                    "\"404 error\": \"Not Found\"," +
                    "\"message\": \"Offer with id: " + idParam + " not found. Please enter a valid offer id.\"," +
                    "\"message2\": \"No Offer was deleted.\"" +
                    "}";

            ctx.json(failureMessage).status(404);
        };
    };
}
