package Checkings;

import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.beans.Specs_Bean;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.example.GamerListsAPI.manager.ConnectionRequest;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class test2 {
    public static void main(String[] args) throws SQLException {
        RequestConnectionDetails cR = new ConnectionRequest().connectionRequest();
        ResultSet rs = new test2().getGamer_byID(5,cR);

        List<GamerInfo_Bean> gamesList = new ArrayList<>();
        Map<Object, Object> gamerMap = null;

        System.out.println(rs.next());

        while (rs.next()) {
            GamerInfo_Bean gamerInfoBean = new GamerInfo_Bean();
            GameInfo_Bean gameInfoBean = new GameInfo_Bean();
            Specs_Bean specsBean = new Specs_Bean();
            specsBean.setProcessor(rs.getString("Processor"));
            specsBean.setRam(rs.getString("Ram"));
            specsBean.setGraphicsCard(rs.getString("GraphicsCard"));

            gameInfoBean.setGameId(rs.getInt("GameId"));
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
        gamerMap = new GamerDTO().gamerInfo2(gamesList);
        List<JSONObject> a = new ArrayList<>();

        JSONObject p1 = new JSONObject(gamerMap);
        a.add(p1);

        System.out.println(a);
    }


    public ResultSet getGamer_byID(int id, RequestConnectionDetails connectionDetails) throws SQLException {
        Integer check = null;

        List<Map<Object,Object>> gamesList = new ArrayList<>();
        Map<Object, Object> gamerMap = null;

        GamerInfo_Bean gamerInfoBean = new GamerInfo_Bean();
        GameInfo_Bean gameInfoBean = new GameInfo_Bean();
        Specs_Bean specsBean = new Specs_Bean();

        String SQL = "select ID, FName, LName, EmailAddress, Gender, GI.GameId, GI.GameName, GI.Publisher, GI.LaunchDate, GI.version, GI.Processor, GI.Ram, GI.GraphicsCard from Gamers G\n" +
                "inner join MappingGamers MG on (MG.GamerID = G.ID)\n" +
                "inner join GameInfo GI on (MG.GameId = GI.GameId)\n" +
                "where G.ID = ";

        Statement statement = connectionDetails.getDbConnection().createStatement();
        ResultSet rs = statement.executeQuery(SQL+id);
//        rs.next();
//        try {
//            check = rs.getInt("ID");
//        } catch (SQLException ignored) {
//        } finally {
//            if (check != null) {
//                specsBean.setProcessor(rs.getString("Processor"));
//                specsBean.setRam(rs.getString("Ram"));
//                specsBean.setGraphicsCard(rs.getString("GraphicsCard"));
//
//                gameInfoBean.setGameId(rs.getInt("GameId"));
//                gameInfoBean.setGameName(rs.getString("GameName"));
//                gameInfoBean.setPublisher(rs.getString("Publisher"));
//                gameInfoBean.setLaunchDate(rs.getString("LaunchDate"));
//                gameInfoBean.setVersion(rs.getString("version"));
//                gameInfoBean.setSpecs(specsBean);
//
//                gamerInfoBean.setGamerId(rs.getInt("ID"));
//                gamerInfoBean.setGamerFName(rs.getString("FName"));
//                gamerInfoBean.setGamerLName(rs.getString("LName"));
//                gamerInfoBean.setEmailAddress(rs.getString("EmailAddress"));
//                gamerInfoBean.setGender(rs.getString("Gender"));
//                gamerInfoBean.setGameInfo(gameInfoBean);
//
//                gamerMap = new GamerDTO().gamerInfo(gamerInfoBean);
//            }
//        }
//        connectionDetails.getDbConnection().close();
//        return gamerMap;
        return rs;
    }
}
