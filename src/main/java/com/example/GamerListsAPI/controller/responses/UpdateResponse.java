package com.example.GamerListsAPI.controller.responses;

import com.example.GamerListsAPI.adaptors.UpdateGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.implementations.DB_Imp.UpdateInfoDB;
import com.example.GamerListsAPI.manager.ConnectionRequest;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class UpdateResponse {
    public Response response(ReturnedObjects returnedObjects){
        String r = "Id not found.";
        Response response = null;
        if (returnedObjects.isFlag())
        {
            r = "Update Success";
            response = Response.status(200).entity(r).build();
        }
        else if (returnedObjects.getSqlException() != null) {
            if (returnedObjects.getSqlException().getErrorCode() == 2627) {
                r = "Duplicate ID";
                response = Response.status(204).entity(r).build();
            }
            else if (returnedObjects.getSqlException().getErrorCode() == 547){
                r = "No / Already reference exists";
                response = Response.status(204).entity(r).build();
            }
        }
        else if (returnedObjects.getE() != null){
            r = returnedObjects.getE().getMessage();
            response = Response.status(204).entity(r).build();
        }
        else
            response = Response.status(200).entity(r).build();

        return response;
    }
    public Response updateGamersInfo(Integer id, String fName, String lName, String email, String gender) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        UpdateGamersInfo ugi = new UpdateInfoDB();
        returnedObjects = ugi.updateGamerInfo(id,fName,lName,email,gender,cR);

        cR.getDbConnection().close();

        return new UpdateResponse().response(returnedObjects);
    }
    public Response updateGameInfo(Integer gameId, String gameName, String publisher, String launchDate, String version, String processor, String ram, String graphicsCard) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        UpdateGamersInfo ugi = new UpdateInfoDB();
        returnedObjects = ugi.updateGameInfo(gameId,gameName,publisher,launchDate,version,processor,ram,graphicsCard,cR);

        cR.getDbConnection().close();

        return new UpdateResponse().response(returnedObjects);
    }
    public Response updateGamerMappingInfo(Integer gamerId, Integer gameId_Old, Integer gameId_New) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        UpdateGamersInfo ugi = new UpdateInfoDB();
        returnedObjects = ugi.updateGamerMappingInfo(gamerId, gameId_Old, gameId_New,cR);

        cR.getDbConnection().close();

        return new UpdateResponse().response(returnedObjects);
    }
}
