package com.carDealership.model;

public enum OfferStatus {
    OPEN("OPEN"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    final String value;

    OfferStatus(String value) {
        this.value = value;
    };
}
