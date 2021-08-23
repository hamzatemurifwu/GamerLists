package Checkings;

import java.sql.*;

public class mssqlconnect {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DEVVM34-HAMZA-T:1433;databaseName=Sample_DB;integratedSecurity=true";
        String userName = "";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url,userName,password);
             Statement statement = connection.createStatement()) {

            String SQL = "SELECT *\n" +
                    "FROM Gamers\n" +
                    "         FULL OUTER JOIN GameInfo\n" +
                    "                         ON Gamers.GameId = GameInfo.GameId";
            ResultSet rs = statement.executeQuery(SQL);

            int size =0;
            while (rs.next()){
                size++;
            }
            System.out.println(size);
            connection.close();

            Connection connection2 = DriverManager.getConnection(url,userName,password);
            Statement statement2 = connection2.createStatement();
            ResultSet rs2 = statement2.executeQuery(SQL);

            rs2.next();

            System.out.println(rs2.getMetaData());

            System.out.println(rs2.getString("ID"));
            System.out.println(rs2.getString("FName"));
            System.out.println(rs2.getString("GameName"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
