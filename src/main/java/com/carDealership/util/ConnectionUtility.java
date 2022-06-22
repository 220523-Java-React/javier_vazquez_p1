package com.carDealership.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {

    private static Connection instance;
    private static Properties connectionProperties;

    public static Connection getConnection() throws SQLException{
        System.out.println("attempting to get connection");

            if (connectionProperties == null) {
                connectionProperties = loadConnectionProperties();
            }

            if (instance == null || instance.isClosed()) {
                    instance = DriverManager.getConnection(
                            connectionProperties.getProperty("url"),
                            connectionProperties.getProperty("user"),
                            connectionProperties.getProperty("password")
                    );

                System.out.println("creating connection");
            }
            else {
                System.out.println("already connected");
            }

        return instance;
    };

    public static Properties loadConnectionProperties() {
        Properties connectionProperties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/db-config.properties");
            connectionProperties.load(fileInputStream);
        }
        catch(IOException e) {
            e.printStackTrace();
        };

        return connectionProperties;
    };
}
