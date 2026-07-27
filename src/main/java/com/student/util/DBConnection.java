package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    // Allow overriding via system property DB_URL or environment variable DB_URL.
    // Falls back to the default MySQL port 3306 and common connector params.
    private static final String URL = System.getProperty("DB_URL") != null ? System.getProperty("DB_URL")
            : (System.getenv("DB_URL") != null ? System.getenv("DB_URL")
            : "jdbc:mysql://localhost:8889/studentdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");

    private static final String USER = System.getProperty("DB_USER") != null ? System.getProperty("DB_USER")
            : (System.getenv("DB_USER") != null ? System.getenv("DB_USER") : "root");

    private static final String PASSWORD = System.getProperty("DB_PASSWORD") != null ? System.getProperty("DB_PASSWORD")
            : (System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "root");

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            LOGGER.info("Database Connected.");

            return connection;

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Database Connection Error. URL=" + URL + " user=" + USER, e);
        }

        return null;
    }

    // Expose the URL for diagnostic purposes (read-only).
    public static String getUrl() {
        return URL;
    }

}