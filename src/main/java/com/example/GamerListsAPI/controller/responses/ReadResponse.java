package com.example.GamerListsAPI.controller.responses;

import com.example.GamerListsAPI.adaptors.GetGamersInfo;
import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.ReadInfoDB;
import com.example.GamerListsAPI.implementations.JSON_Imp.ReadInfoJSON;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.manager.ConnectionRequest;
import com.example.GamerListsAPI.manager.DataSourceRequest;
import org.json.simple.JSONObject;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

public class ReadResponse {
    public Response response(ReturnedObjects returnedObjects,Integer id) {
        if (returnedObjects.getMap() == null) {
            return Response
                    .status(204)
                    .entity("No Gamer Found")
                    .build();
        }
        JSONObject gamerJson_Obj = new JSONObject(returnedObjects.getMap());

        return Response
                .status(200)
                .entity(gamerJson_Obj)
                .build();
    }
    public Response gamerResponse_DB(Integer id) throws SQLException, IOException {
        ReturnedObjects returnedObjects;
        GetGamersInfo gamerInfo = new ReadInfoDB();
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();

        returnedObjects = gamerInfo.getGamer_byID(id, cR);
        cR.getDbConnection().close();

        return new ReadResponse().response(returnedObjects, id);
    }
    public Response gameResponse_DB(Integer gameId) throws SQLException, IOException {
        ReturnedObjects returnedObjects;
        GetGamersInfo gamerInfo = new ReadInfoDB();
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();

        returnedObjects = gamerInfo.getGame_byID(gameId, cR);
        cR.getDbConnection().close();

        return new ReadResponse().response(returnedObjects, gameId);
    }

    public Response gamerResponse_JSON(Integer id) throws SQLException, IOException {
        ReturnedObjects returnedObjects;
        GetGamersInfo gamerInfo = new ReadInfoJSON();
        DataSourceRequest dsR = new DataSourceRequest();

        returnedObjects = gamerInfo.getGamer_byID(id, dsR.dataSourceRequest());

        return new ReadResponse().response(returnedObjects,id);
    }
    public Response gameResponse_JSON(Integer gameId) throws SQLException, IOException {
        ReturnedObjects returnedObjects;
        GetGamersInfo gameInfo = new ReadInfoJSON();
        DataSourceRequest dsR = new DataSourceRequest();

        returnedObjects = gameInfo.getGame_byID(gameId, dsR.dataSourceRequest());

        return new ReadResponse().response(returnedObjects,gameId);
    }
}
