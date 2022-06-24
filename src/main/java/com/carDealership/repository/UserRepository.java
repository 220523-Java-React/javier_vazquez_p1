package com.carDealership.repository;

import com.carDealership.model.Role;
import com.carDealership.model.User;
import com.carDealership.util.ConnectionUtility;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements DAO<User>{

    // Create user
    @Override
    public User create(User user) {

        String sql = "insert into users(first_name, last_name, username, password, email, role_id) values(?,?,?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setInt(6, user.getRole().ordinal());

            int success = stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                int id = keys.getInt(1);
                if (id != 0) {
                    return user.setId(id);
                }
            }
        }
        catch(PSQLException e) {
            User notAUser = new User();
            notAUser.setFirstName("NOT_CREATED");

            return notAUser;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

    // Get all users
    @Override
    public List<User> getAll() {

        List<User> users = new ArrayList<>();

        String sql = "select * from users";

        try (Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                users.add(
                    new User()
                        .setId(results.getLong("id"))
                        .setFirstName(results.getString("first_name"))
                        .setLastName(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setEmail(results.getString("email"))
                        .setRole(Role.values()[results.getInt("role_id")])
                );
            };

        }
        catch (SQLException e){
            return null;
        };

        return users;
    }

    // Get user by id
    @Override
    public User getById(long id) {
        String sql = "select * from users where id = ?";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                User user = new User();
                user
                    .setId(results.getLong("id"))
                    .setFirstName(results.getString("first_name"))
                    .setLastName(results.getString("last_name"))
                    .setUsername(results.getString("username"))
                    .setPassword(results.getString("password"))
                    .setEmail(results.getString("email"))
                    .setRole(Role.values()[results.getInt("role_id")]);

                return user;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

    // Update user by id
    @Override
    public User updateById(User user, long id) {

        String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ?, email = ? , role_id = ? where id = ? ";

        try(Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setInt(6, user.getRole().ordinal());

            stmt.setLong(7, id);

            int success = stmt.executeUpdate();

            if(success != 0) {
                return getById(id);
            }
        }
        catch(PSQLException e) {
            User notAUser = new User();
            notAUser.setFirstName("NOT_UPDATED");

            return notAUser;
        }
        catch(SQLException e) {
            e.printStackTrace();
        };

        return null;
    };

//    // Update user by params
//    @Override
//    public User updateByParams(User user, List<String> params) {
//        return user;
//    };

    // Delete user by id
    @Override
    public User deleteById(long id) {
      String sql = "delete from users where id = ?";

      try(Connection connection = ConnectionUtility.getConnection()) {
          PreparedStatement stmt = connection.prepareStatement(sql);
          stmt.setLong(1, id);

          int success = stmt.executeUpdate();

          if (success != 0) {
              return new User().setFirstName("DELETED_USER");
          }
      }
      catch (SQLException e) {
          e.printStackTrace();
      };

        User user = getById(id);
        return new User();

    };
}
