package com.carDealership.controller;

import com.carDealership.service.DealerLotService;
import io.javalin.http.Handler;

public class DealerLotController {
    DealerLotService dealerLotService;

    public DealerLotController() {
        dealerLotService = new DealerLotService();
    };

    public DealerLotController(DealerLotService dealerLotService) {
        this.dealerLotService = dealerLotService;
    };

    public Handler getCarsOnLot = ctx -> {
        ctx.json(dealerLotService.getAllCarsOnLot());
    };
};
