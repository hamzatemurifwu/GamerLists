package com.example.GamerListsAPI.implementations.DB_Imp;

import com.example.GamerListsAPI.adaptors.InsertGamersInfo;
import com.example.GamerListsAPI.adaptors.UpdateGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateInfoDB implements UpdateGamersInfo {
    @Override
    public ReturnedObjects updateGamerInfo(Integer id,
                                     String fName,
                                     String lName,
                                     String email,
                                     String gender,
                                     RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "update Gamers\n" +
                "set FName = ?, LName = ?, EmailAddress = ?, Gender = ?\n" +
                "where ID = ?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setString(1, fName);
            stmt.setString(2, lName);
            stmt.setString(3, email);
            stmt.setString(4, gender);
            stmt.setInt(5, id);
            int rs = stmt.executeUpdate();
            if (rs==1)
                returnedObjects.setFlag(true);
        } catch (SQLException e) {
            returnedObjects.setSqlException(e);
        }
        catch (Exception e) {
            returnedObjects.setE(e);
        }
        return returnedObjects;
    }
    @Override
    public ReturnedObjects updateGameInfo(Integer gameId,
                             String gameName,
                             String publisher,
                             String launchDate,
                             String version,
                             String processor,
                             String ram,
                             String graphicsCard,
                             RequestConnectionDetails connectionDetails) throws SQLException{
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "update GameInfo\n" +
                "set GameName=?, Publisher=?, LaunchDate=?, version=?, Processor=?, Ram=?, GraphicsCard=?\n" +
                "where GameId=?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setString(1, gameName);
            stmt.setString(2, publisher);
            stmt.setString(3, launchDate);
            stmt.setString(4, version);
            stmt.setString(5, processor);
            stmt.setString(6, ram);
            stmt.setString(7, graphicsCard);
            stmt.setInt(8, gameId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            returnedObjects.setSqlException(e);
        }
        catch (Exception e) {
            returnedObjects.setE(e);
        }
        return returnedObjects;
    }
    @Override
    public ReturnedObjects updateGamerMappingInfo(Integer gamerId,
                                            Integer gameId_Old,
                                            Integer gameId_New,
                                            RequestConnectionDetails connectionDetails) throws SQLException{
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "update MappingGamers\n" +
                "set GameID = ?\n" +
                "where GamerID = ? and GameID = ?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, gameId_New);
            stmt.setInt(2, gamerId);
            stmt.setInt(3, gameId_Old);
            stmt.executeUpdate();
        } catch (SQLException e) {
            returnedObjects.setSqlException(e);
        }
        catch (Exception e) {
            returnedObjects.setE(e);
        }
        return returnedObjects;
    }
}
