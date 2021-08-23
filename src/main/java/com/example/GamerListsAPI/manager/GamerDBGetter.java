package com.example.GamerListsAPI.manager;

import java.sql.*;

public class GamerDBGetter {
    String url = "jdbc:sqlserver://FW62;databaseName=filos;integratedSecurity=true";
    String userName = "";
    String password = "";

    public ResultSet getGamersData(){
        ResultSet rs = null;
        try (Connection connection = DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement()) {

            String SQL = "SELECT *\n" +
                    "FROM Gamers\n" +
                    "         FULL OUTER JOIN GameInfo\n" +
                    "                         ON Gamers.GameId = GameInfo.GameId";
            rs = statement.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                return rs;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
