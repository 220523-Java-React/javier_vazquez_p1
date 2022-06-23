package com.carDealership.model;

public enum Role {
    MANAGER("MANAGER"),
    SALESMAN("SALESMAN"),
    BUYER("BUYER");

    final String value;

    Role(String value) {
        this.value = value;
    };
};