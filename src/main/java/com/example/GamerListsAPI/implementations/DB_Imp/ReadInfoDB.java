package com.example.GamerListsAPI.implementations.DB_Imp;

import com.example.GamerListsAPI.adaptors.GetGamersInfo;
import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.Specs_Bean;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.example.GamerListsAPI.dto.ReturnedObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadInfoDB implements GetGamersInfo {
    @Override
    public ReturnedObjects getGamer_byID(Integer id, RequestConnectionDetails connectionDetails) {
        ReturnedObjects returnedObjects = new ReturnedObjects();
        Map<Object, Object> gamerMap = null;
        List<GamerInfo_Bean> gamesList = new ArrayList<>();

        String sql = "select ID, FName, LName, EmailAddress, Gender, GI.GameId, GI.GameName, GI.Publisher, GI.LaunchDate, GI.version, GI.Processor, GI.Ram, GI.GraphicsCard from Gamers G\n" +
                "left join MappingGamers MG on (MG.GamerID = G.ID)\n" +
                "left join GameInfo GI on (MG.GameId = GI.GameId)\n" +
                "where G.ID = ";

        try(Statement statement = connectionDetails.getDbConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql + id)) {
            while (rs.next()) {
                GamerInfo_Bean gamerInfoBean = new GamerInfo_Bean();
                GameInfo_Bean gameInfoBean = new GameInfo_Bean();
                Specs_Bean specsBean = new Specs_Bean();

                specsBean.setProcessor(rs.getString("Processor"));
                specsBean.setRam(rs.getString("Ram"));
                specsBean.setGraphicsCard(rs.getString("GraphicsCard"));

                if (rs.getInt("GameId") == 0) gameInfoBean.setGameId(null);
                else gameInfoBean.setGameId(rs.getInt("GameId"));
                gameInfoBean.setGameName(rs.getString("GameName"));
                gameInfoBean.setPublisher(rs.getString("Publisher"));
                gameInfoBean.setLaunchDate(rs.getString("LaunchDate"));
                gameInfoBean.setVersion(rs.getString("version"));
                gameInfoBean.setSpecs(specsBean);

                gamerInfoBean.setGamerId(rs.getInt("ID"));
                gamerInfoBean.setGamerFName(rs.getString("FName"));
                gamerInfoBean.setGamerLName(rs.getString("LName"));
                gamerInfoBean.setEmailAddress(rs.getString("EmailAddress"));
                gamerInfoBean.setGender(rs.getString("Gender"));
                gamerInfoBean.setGameInfo(gameInfoBean);

                gamesList.add(gamerInfoBean);
            }
            if (gamesList.size()!=0)
                gamerMap = new GamerDTO().gamerInfo2(gamesList);
        }
        catch (SQLException e){
            returnedObjects.setSqlException(e);
        }
        catch (Exception e) {
            returnedObjects.setE(e);
        }
        returnedObjects.setMap(gamerMap);

        return returnedObjects;
    }

    @Override
    public ReturnedObjects getGame_byID(Integer gameId, RequestConnectionDetails connectionDetails) throws SQLException {
        ReturnedObjects returnedObjects = new ReturnedObjects();
        Map<Object, Object> gameMap = null;

        GameInfo_Bean gameInfoBean = new GameInfo_Bean();
        Specs_Bean specsBean = new Specs_Bean();

        String sql = "select * from GameInfo\n" +
                "where GameId = ";

        try (Statement statement = connectionDetails.getDbConnection().createStatement();
             ResultSet rs = statement.executeQuery(sql + gameId)) {
            while (rs.next()) {
                specsBean.setProcessor(rs.getString("Processor"));
                specsBean.setRam(rs.getString("Ram"));
                specsBean.setGraphicsCard(rs.getString("GraphicsCard"));

                if (rs.getInt("GameId") == 0) gameInfoBean.setGameId(null);
                else gameInfoBean.setGameId(rs.getInt("GameId"));
                gameInfoBean.setGameName(rs.getString("GameName"));
                gameInfoBean.setPublisher(rs.getString("Publisher"));
                gameInfoBean.setLaunchDate(rs.getString("LaunchDate"));
                gameInfoBean.setVersion(rs.getString("version"));
                gameInfoBean.setSpecs(specsBean);
                gameMap = new GamerDTO().gameInfo(gameInfoBean);
            }
            returnedObjects.setMap(gameMap);
        }
        catch (SQLException e) {
            returnedObjects.setSqlException(e);
        }
        catch (Exception e) {
            returnedObjects.setE(e);
        }
        return returnedObjects;
    }
}