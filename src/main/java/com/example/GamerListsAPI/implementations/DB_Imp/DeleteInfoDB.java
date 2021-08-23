package com.example.GamerListsAPI.implementations.DB_Imp;

import com.example.GamerListsAPI.adaptors.DeleteGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteInfoDB implements DeleteGamersInfo {
    @Override
    public ReturnedObjects delGamerInfo(Integer id,
                                  RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "delete from Gamers\n" +
                "where ID = ?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, id);
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
    public ReturnedObjects delGameInfo(Integer id,
                                  RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "delete from GameInfo\n" +
                "where GameId = ?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, id);
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
    public ReturnedObjects delGamerMappingInfo(Integer gamerId,
                                        Integer gameId,
                                        RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();

        String sql = "delete from MappingGamers\n" +
                "where GamerID = ? and GameID = ?";

        PreparedStatement stmt = null;
        try {
            stmt = connectionDetails.getDbConnection().prepareStatement(sql);
            stmt.setInt(1, gamerId);
            stmt.setInt(2, gameId);
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
}
