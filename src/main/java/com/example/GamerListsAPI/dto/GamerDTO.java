package com.example.GamerListsAPI.dto;

import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.beans.testbeans.B1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamerDTO {
    public Map<Object, Object> gamerInfo(B1 gamerInfo_bean){

        List<Map<Object, Object>> gmlist = new ArrayList<>();

        Map<Object, Object> gamerInfo_obj = new HashMap<>();

        gamerInfo_obj.put("gamerId", gamerInfo_bean.getGamerId());
        gamerInfo_obj.put("gamerFName", gamerInfo_bean.getGamerFName());
        gamerInfo_obj.put("gamerLName", gamerInfo_bean.getGamerLName());
        gamerInfo_obj.put("gender", gamerInfo_bean.getGender());
        gamerInfo_obj.put("emailAddress", gamerInfo_bean.getEmailAddress());

        for (GameInfo_Bean a:gamerInfo_bean.getGameInfo()) {
            Map<Object, Object> temp_gameInfo_obj = new HashMap<>();
            Map<Object, Object> temp_specs_obj = new HashMap<>();

            temp_specs_obj.put("processor", a.getSpecs().getProcessor());
            temp_specs_obj.put("ram", a.getSpecs().getRam());
            temp_specs_obj.put("graphicsCard", a.getSpecs().getGraphicsCard());
            temp_gameInfo_obj.put("specs", temp_specs_obj);

            temp_gameInfo_obj.put("gameId", a.getGameId());
            temp_gameInfo_obj.put("gameName", a.getGameName());
            temp_gameInfo_obj.put("publisher", a.getPublisher());
            temp_gameInfo_obj.put("version", a.getVersion());
            temp_gameInfo_obj.put("launchDate", a.getLaunchDate());

            gmlist.add(temp_gameInfo_obj);
        }
        gamerInfo_obj.put("gameInfo", gmlist);

        return gamerInfo_obj;
    }

    public Map<Object, Object> gamerInfo2(List<GamerInfo_Bean> gamerInfo_beanList){
        List<Map<Object, Object>> list = new ArrayList<>();

        Map<Object, Object> gamerInfo_obj = new HashMap<>();

        for (GamerInfo_Bean g:gamerInfo_beanList) {
            gamerInfo_obj.put("gamerId", g.getGamerId());
            gamerInfo_obj.put("gamerFName", g.getGamerFName());
            gamerInfo_obj.put("gamerLName", g.getGamerLName());
            gamerInfo_obj.put("gender", g.getGender());
            gamerInfo_obj.put("emailAddress", g.getEmailAddress());

            Map<Object, Object> gameInfo_obj = new HashMap<>();
            Map<Object, Object> specs_obj = new HashMap<>();

            specs_obj.put("processor", g.getGameInfo().getSpecs().getProcessor());
            specs_obj.put("ram", g.getGameInfo().getSpecs().getRam());
            specs_obj.put("graphicsCard", g.getGameInfo().getSpecs().getGraphicsCard());

            gameInfo_obj.put("specs", specs_obj);

            gameInfo_obj.put("gameId", g.getGameInfo().getGameId());
            gameInfo_obj.put("gameName", g.getGameInfo().getGameName());
            gameInfo_obj.put("publisher", g.getGameInfo().getPublisher());
            gameInfo_obj.put("version", g.getGameInfo().getVersion());
            gameInfo_obj.put("launchDate", g.getGameInfo().getLaunchDate());

            list.add(gameInfo_obj);
        }

        if (list.size()>0)
            gamerInfo_obj.put("gameInfo",list);

        return gamerInfo_obj;
    }

    public Map<Object, Object> gameInfo(GameInfo_Bean gBean){
        Map<Object, Object> gameInfo_obj = new HashMap<>();
        Map<Object, Object> specs_obj = new HashMap<>();

        specs_obj.put("processor", gBean.getSpecs().getProcessor());
        specs_obj.put("ram", gBean.getSpecs().getRam());
        specs_obj.put("graphicsCard", gBean.getSpecs().getGraphicsCard());

        gameInfo_obj.put("specs", specs_obj);

        gameInfo_obj.put("gameId", gBean.getGameId());
        gameInfo_obj.put("gameName", gBean.getGameName());
        gameInfo_obj.put("publisher", gBean.getPublisher());
        gameInfo_obj.put("version", gBean.getVersion());
        gameInfo_obj.put("launchDate", gBean.getLaunchDate());

        return gameInfo_obj;
    }
}
