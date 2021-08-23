package com.example.GamerListsAPI.implementations.JSON_Imp;

import com.example.GamerListsAPI.adaptors.GetGamersInfo;
import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.testbeans.B1;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class ReadInfoJSON implements GetGamersInfo {
    @Override
    public ReturnedObjects getGamer_byID(Integer id, RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();
        Map<Object, Object> gamerMap = null;
        String contentFile = connectionDetails.getDataSource();

        Type type = new TypeToken<List<B1>>() {
        }.getType();
        List<B1> fromJson = new Gson().fromJson(contentFile, type);

        for (B1 gInfo:fromJson) {
            if (gInfo.getGamerId()==id){
                gamerMap = new GamerDTO().gamerInfo(gInfo);
                break;
            }
        }
        returnedObjects.setMap(gamerMap);
        return returnedObjects;
    }
    @Override
    public ReturnedObjects getGame_byID(Integer id, RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();
        Map<Object, Object> gameMap = null;
        String contentFile = connectionDetails.getDataSource();

        Type type = new TypeToken<List<B1>>() {
        }.getType();
        List<B1> fromJson = new Gson().fromJson(contentFile, type);

        for (B1 gInfo:fromJson) {
            for (GameInfo_Bean game:gInfo.getGameInfo()) {
                if (game.getGameId().equals(id))
                {
                    gameMap = new GamerDTO().gameInfo(game);
                    break;
                }
            }
        }
        returnedObjects.setMap(gameMap);
        return returnedObjects;
    }
}
