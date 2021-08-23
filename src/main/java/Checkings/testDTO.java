package Checkings;

import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.beans.Specs_Bean;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.example.GamerListsAPI.manager.GamerManager;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testDTO {
    public static void main(String[] args) {
        List<Map<Object, Object>> gamerMap = new ArrayList<>();

        List<GamerInfo_Bean> gamesList = new ArrayList<>();

        GamerInfo_Bean gamerInfoBean = new GamerInfo_Bean();
        GameInfo_Bean gameInfoBean = new GameInfo_Bean();
        Specs_Bean specsBean = new Specs_Bean();

        specsBean.setProcessor("i13");
        specsBean.setRam("32gb");
        specsBean.setGraphicsCard("titan x");

        gameInfoBean.setGameId(10);
        gameInfoBean.setGameName("r6s");
        gameInfoBean.setPublisher("ubi");
        gameInfoBean.setLaunchDate("2012");
        gameInfoBean.setVersion("2.2");
        gameInfoBean.setSpecs(specsBean);

        gamerInfoBean.setGamerId(1);
        gamerInfoBean.setGamerFName("osama");
        gamerInfoBean.setGamerLName("jamil");
        gamerInfoBean.setEmailAddress("asb@skj.sad");
        gamerInfoBean.setGender("male");
        gamerInfoBean.setGameInfo(gameInfoBean);

        gamesList.add(gamerInfoBean);

        gamerMap.add(new GamerDTO().gamerInfo2(gamesList));
        gamesList = new ArrayList<>();

        specsBean.setProcessor("xenon");
        specsBean.setRam("4gb");
        specsBean.setGraphicsCard("quodro");

        gameInfoBean.setGameId(20);
        gameInfoBean.setGameName("r6sds");
        gameInfoBean.setPublisher("ubioosaio");
        gameInfoBean.setLaunchDate("201231");
        gameInfoBean.setVersion("2.82");
        gameInfoBean.setSpecs(specsBean);

        gamerInfoBean.setGamerId(2);
        gamerInfoBean.setGamerFName("taha");
        gamerInfoBean.setGamerLName("ahmed");
        gamerInfoBean.setEmailAddress("asb21@saskj.sad");
        gamerInfoBean.setGender("male");
        gamerInfoBean.setGameInfo(gameInfoBean);

        gamesList.add(gamerInfoBean);

        gamerMap.add(new GamerDTO().gamerInfo2(gamesList));

        List<JSONObject> a = new ArrayList<>();

        JSONObject p1 = new JSONObject(gamerMap.get(0));
        JSONObject p2 = new JSONObject(gamerMap.get(1));

        a.add(p1);
        a.add(p2);

        new GamerManager().saveGamerFile(a);
    }
}
