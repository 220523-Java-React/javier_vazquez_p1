package com.carDealership.service;

import com.carDealership.model.Offer;
import com.carDealership.repository.OfferRepository;

import java.util.List;

public class OfferService {
    OfferRepository offerRepository;

    public OfferService() {
        offerRepository = new OfferRepository();
    };

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    };

    public List<Offer> getAllOffers() {
        return offerRepository.getAll();
    }
}
