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
    };

    public List<Offer> getAllOffers() {
        return offerRepository.getAll();
    };

    public Offer getOfferById(long id) {
        return offerRepository.getById(id);
    };

    public List<Offer> getOffersByOfferMaker(long offerMaker) {
        return offerRepository.getOffersByOfferMaker(offerMaker);
    };

    public Offer updateOfferById(Offer offer, long id) {
        return offerRepository.updateById(offer, id);
    };

    public Offer deleteOfferById(long id) {
        return offerRepository.deleteById(id);
    };
};
