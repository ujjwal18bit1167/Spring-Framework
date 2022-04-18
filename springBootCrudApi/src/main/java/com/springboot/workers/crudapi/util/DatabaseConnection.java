package com.springboot.workers.crudapi.util;


import java.sql.*;

public class DatabaseConnection {
	
    static final String url = "jdbc:mysql://localhost:3306/myOrg";
    static final String username = "root";
    static final String password = "HanumanJii";
    private static Connection con = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to database server "
                    + con.getMetaData().getDatabaseProductName()
                    + " version: "
                    + con.getMetaData().getDatabaseProductVersion());
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}