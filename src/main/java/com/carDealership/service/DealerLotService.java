package com.carDealership.service;

import com.carDealership.model.Car;
import com.carDealership.repository.DealerLotRepository;

import java.util.List;

public class DealerLotService {
    DealerLotRepository dealerLotRepository;

    public DealerLotService() {
        dealerLotRepository = new DealerLotRepository();
    };

    public DealerLotService(DealerLotRepository dealerLotRepository) {
        this.dealerLotRepository = dealerLotRepository;
    };

    public List<Car> getAllCarsOnLot() {
        return dealerLotRepository.getAllCarsOnLot();
    };
};
