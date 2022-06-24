package com.carDealership.model;

import java.util.Objects;

public class Offer {

    private long id;
    private long offerMaker;
    private long carId;
    private double offerAmount;
    private OfferStatus offerStatus;

    public Offer() {};

    public Offer(long id, long offerMaker, long carId, double offerAmount, OfferStatus offerStatus) {
        this.id = id;
        this.offerMaker = offerMaker;
        this.carId = carId;
        this.offerAmount = offerAmount;
        this.offerStatus = offerStatus;
    };

    public long getId() {
        return id;
    }

    public Offer setId(long id) {
        this.id = id;
        return this;
    };

    public long getOfferMaker() {
        return offerMaker;
    };

    public Offer setOfferMaker(long offerMaker) {
        this.offerMaker = offerMaker;
        return this;
    };

    public long getCarId() {
        return carId;
    };

    public Offer setCarId(long carId) {
        this.carId = carId;
        return this;
    };

    public double getOfferAmount() {
        return offerAmount;
    };

    public Offer setOfferAmount(double offerAmount) {
        this.offerAmount = offerAmount;
        return this;
    };

    public OfferStatus getOfferStatus() {
        return offerStatus;
    };

    public Offer setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id == offer.id && carId == offer.carId && Double.compare(offer.offerAmount, offerAmount) == 0 && Objects.equals(offerMaker, offer.offerMaker) && offerStatus == offer.offerStatus;
    };

    @Override
    public int hashCode() {
        return Objects.hash(id, offerMaker, carId, offerAmount, offerStatus);
    };

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", offerMaker=" + offerMaker +
                ", carId=" + carId +
                ", offerAmount=" + offerAmount +
                ", offerStatus=" + offerStatus +
                '}';
    };
};

