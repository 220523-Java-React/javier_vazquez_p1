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

    public Offer createOffer(Offer offer) {
        return offerRepository.create(offer);
    }

    public List<Offer> getAllOffers() {
        return offerRepository.getAll();
    }
}
