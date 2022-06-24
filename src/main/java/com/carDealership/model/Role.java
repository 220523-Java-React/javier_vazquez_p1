package com.carDealership.model;

public enum Role {
    CUSTOMER("CUSTOMER"),
    EMPLOYEE("EMPLOYEE");

    final String value;

    Role(String value) {
        this.value = value;
    };
};