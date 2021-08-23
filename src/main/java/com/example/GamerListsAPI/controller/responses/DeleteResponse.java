package com.example.GamerListsAPI.controller.responses;

import com.example.GamerListsAPI.adaptors.*;
import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.DeleteInfoDB;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.manager.ConnectionRequest;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

public class DeleteResponse {
    public Response response(ReturnedObjects returnedObjects){
        String r = "Id not found.";
        Response response = null;
        if (returnedObjects.isFlag())
        {
            r = "Delete Success";
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
    public Response delGamersInfo_byId(Integer id) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        DeleteGamersInfo dgi = new DeleteInfoDB();

        returnedObjects = dgi.delGamerInfo(id, cR);

        cR.getDbConnection().close();

        return new DeleteResponse().response(returnedObjects);
    }
    public Response delGameInfo_byId(Integer id) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        DeleteGamersInfo dgi = new DeleteInfoDB();

        returnedObjects = dgi.delGameInfo(id, cR);

        cR.getDbConnection().close();

        return new DeleteResponse().response(returnedObjects);
    }
    public Response delGamerMappingInfo(Integer gamerId, Integer gameId) throws SQLException {
        ReturnedObjects returnedObjects;
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        DeleteGamersInfo dgi = new DeleteInfoDB();

        returnedObjects = dgi.delGamerMappingInfo(gamerId, gameId, cR);

        cR.getDbConnection().close();

        return new DeleteResponse().response(returnedObjects);
    }
}
