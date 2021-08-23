package com.example.GamerListsAPI.implementations.DB_Imp;

import java.sql.Connection;

public class RequestConnectionDetails {
    private Connection dbConnection;
    private String dataSource;

    public Connection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}
