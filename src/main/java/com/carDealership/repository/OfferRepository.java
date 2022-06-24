package com.carDealership.repository;

import com.carDealership.model.Offer;
import com.carDealership.model.OfferStatus;
import com.carDealership.util.ConnectionUtility;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferRepository implements DAO<Offer>{
    @Override
    public Offer create(Offer offer) {
        String sql = "insert into offers(offer_maker, car_id, offer_amount, offer_status_id) values(?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, offer.getOfferMaker());
            stmt.setLong(2, offer.getCarId());
            stmt.setDouble(3, offer.getOfferAmount());
            stmt.setInt(4, offer.getOfferStatus().ordinal());

            int success = stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                int id = keys.getInt(1);
                if (id != 0) {
                    return offer.setId(id);
                }
            }
        }
        catch(PSQLException e) {
            Offer notAnOffer = new Offer();
            notAnOffer.setOfferMaker(-9999);

            return notAnOffer;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

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
    };

    @Override
    public Offer getById(long id) {
        String sql = "select * from offers where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                Offer offer = new Offer();
                offer
                        .setId(results.getLong("id"))
                        .setOfferMaker(results.getLong("offer_maker"))
                        .setCarId(results.getLong("car_id"))
                        .setOfferAmount(results.getDouble("offer_amount"))
                        .setOfferStatus(OfferStatus.values()[results.getInt("offer_status_id")]);

                return offer;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

    @Override
    public Offer updateById(Offer offer, long id) {
        String sql = "update offers set offer_maker = ?, car_id = ?, offer_amount = ?, offer_status_id = ? where id = ? ";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, offer.getOfferMaker());
            stmt.setLong(2, offer.getCarId());
            stmt.setDouble(3, offer.getOfferAmount());
            stmt.setInt(4, offer.getOfferStatus().ordinal());

            stmt.setLong(5, id);

            int success = stmt.executeUpdate();

            if(success != 0) {
                return getById(id);
            }
        }
        catch(PSQLException e) {
            Offer notAnOffer = new Offer();
            notAnOffer.setOfferMaker(-1999);

            return notAnOffer;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

    @Override
    public Offer deleteById(long id) {
        return null;
    };
}
