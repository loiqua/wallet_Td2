package com.wallet.wallet2.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionDB {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        String url = Objects.requireNonNull(System.getenv("DB_URL"), "DB_URL must be set");
        String username = Objects.requireNonNull(System.getenv("DB_USER"), "DB_USER must be set");
        String password = Objects.requireNonNull(System.getenv("DB_PASS"), "DB_PASS must be set");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish a database connection", e);
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to close the database connection", e);
            }
        }
    }
}