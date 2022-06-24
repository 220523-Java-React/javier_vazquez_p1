package com.carDealership.repository;

import com.carDealership.model.Offer;
import com.carDealership.model.OfferStatus;
import com.carDealership.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferRepository implements DAO<Offer>{
    @Override
    public Offer create(Offer offer) {
        return null;
    }

    @Override
    public List<Offer> getAll() {
        List<Offer> offers = new ArrayList<>();

        String sql = "select * from offers";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                offers.add(
                        new Offer()
                                .setId(results.getLong("id"))
                                .setOfferMaker(results.getLong("offer_maker"))
                                .setCarId(results.getLong("car_id"))
                                .setOfferAmount(results.getDouble("offer_amount"))
                                .setOfferStatus(OfferStatus.values()[results.getInt("offer_status_id")])
                );
            };
        }
        catch (SQLException e) {
            return null;
        };

        return offers;
    }

    @Override
    public Offer getById(long id) {
        return null;
    }

    @Override
    public Offer updateById(Offer offer, long id) {
        return null;
    }

    @Override
    public Offer deleteById(long id) {
        return null;
    }
}
