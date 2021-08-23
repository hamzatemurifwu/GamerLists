package com.example.GamerListsAPI.controller.responses;

import com.example.GamerListsAPI.adaptors.InsertGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.InsertInfoDB;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.manager.ConnectionRequest;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class InsertResponse {
    public Response response(ReturnedObjects returnedObjects) {
        String r = "Insert Success";
        Response response = null;

        if (returnedObjects.getSqlException() != null) {
            if (returnedObjects.getSqlException().getErrorCode() == 2627) {
                r = "Duplicate ID";
                response = Response.status(204).entity(r).build();
            }
            else if (returnedObjects.getSqlException().getErrorCode() == 547){
                r = "No reference exists";
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
    public Response insertGamersInfo(Integer id, String fName, String lName, String email, String gender) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        InsertGamersInfo igi = new InsertInfoDB();
        returnedObjects = igi.insertGamerInfo(id,fName,lName,email,gender,cR);

        cR.getDbConnection().close();

        return new InsertResponse().response(returnedObjects);
    }
    public Response insertGameInfo(Integer gameId, String gameName, String publisher, String launchDate, String version, String processor, String ram, String graphicsCard) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        InsertGamersInfo igi = new InsertInfoDB();
        returnedObjects = igi.insertGameInfo(gameId,gameName,publisher,launchDate,version,processor,ram,graphicsCard,cR);

        cR.getDbConnection().close();

        return new InsertResponse().response(returnedObjects);
    }
    public Response insertGamerMappingInfo(Integer gamerId, Integer gameId) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        InsertGamersInfo igi = new InsertInfoDB();
        returnedObjects = igi.insertGamersMapping(gamerId, gameId,cR);

        cR.getDbConnection().close();

        return new InsertResponse().response(returnedObjects);
    }
}