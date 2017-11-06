/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.IdentityService;

import java.sql.*;

/**
 *
 * @author adyan
 */
public class ConnectDBAccount {
    private static final String url = "jdbc:mysql://localhost:3306/accountdb?zeroDateTimeBehavior=convertToNull";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "";
    private static Connection connDB;
    
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                connDB = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return connDB;
    }
}
