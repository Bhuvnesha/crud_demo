package com.student.test;

import java.sql.Connection;
import com.student.util.DBConnection;

public class ConnectionTest {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("✅ Database Connected Successfully!");
        } else {
            System.out.println("❌ Database Connection Failed!");
            // Print the attempted JDBC URL to help diagnose connection issues.
            System.out.println("Attempted URL: " + DBConnection.getUrl());
        }
    }
}