package com.example.GamerListsAPI.implementations.DB_Imp;

import com.example.GamerListsAPI.adaptors.InsertGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertInfoDB implements InsertGamersInfo {
    @Override
    public ReturnedObjects insertGamerInfo(Integer id,
                                     String fName,
                                     String lName,
                                     String email,
                                     String gender,
                                     RequestConnectionDetails connectionDetails){
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "insert into Gamers(ID,FName,LName,EmailAddress,Gender)\n" +
                "values (?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, fName);
            stmt.setString(3, lName);
            stmt.setString(4, email);
            stmt.setString(5, gender);
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
    public ReturnedObjects insertGameInfo(Integer gameId,
                        String gameName,
                        String publisher,
                        String launchDate,
                        String version,
                        String processor,
                        String ram,
                        String graphicsCard,
                        RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "insert into GameInfo(GameId,GameName,Publisher,LaunchDate,version,Processor,Ram,GraphicsCard)\n" +
                "values (?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, gameId);
            stmt.setString(2, gameName);
            stmt.setString(3, publisher);
            stmt.setString(4, launchDate);
            stmt.setString(5, version);
            stmt.setString(6, processor);
            stmt.setString(7, ram);
            stmt.setString(8, graphicsCard);
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
    public ReturnedObjects insertGamersMapping(Integer gamerId, Integer gameId, RequestConnectionDetails connectionDetails){
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "insert into MappingGamers (GamerID, GameID)\n" +
                "values (?,?)";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, gamerId);
            stmt.setInt(2, gameId);
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
