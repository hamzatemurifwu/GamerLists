package com.example.GamerListsAPI.controller;

import java.sql.*;

public class DBConnection {
    final String url = "jdbc:sqlserver://DEVVM34-HAMZA-T:1433;databaseName=Sample_DB;integratedSecurity=true";
    final String userName = "";
    final String password = "";
    public Connection conn = null;

    public Connection getDBConn(){
        try {
            conn = DriverManager.getConnection(url,userName,password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConn() throws SQLException {
        conn.close();
    }
}
