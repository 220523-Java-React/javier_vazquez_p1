package com.carDealership.repository;

import java.util.List;

public interface DAO<T> {

    // Create object of type T
    T create(T t);

    // Read - get all in List of type T
    List<T> getAll();

    // Read - get object in List of type T by id
    T getById(long id);

    // Update object of type T by id
    T updateById(T t, long id);

    // Delete object of type T
    T deleteById(long id);
}
