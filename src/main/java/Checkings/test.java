package Checkings;

import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class test {
    public static String readLineByLineJava8(String filePath) {
        String resp = null;
        StringBuilder contentBuilder = new StringBuilder();
        if (Files.exists(Paths.get(filePath))) {
            try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
                stream.forEach(contentBuilder::append);
            } catch (IOException e) {
                e.printStackTrace();
            }
            resp = contentBuilder.toString();
        }
        return resp;
    }

    public static void main(String[] args) {

//        String contentFile = readLineByLineJava8("D:\\Sample-Projects\\test\\src\\main\\resources\\Gamers.json");
//
//        Type type = new TypeToken<List<GamerInfo_Bean>>() {
//        }.getType();
//        List<GamerInfo_Bean> fromJson = new Gson().fromJson(contentFile, type);
//
//        for (GamerInfo_Bean gInfo:fromJson) {
//            if (gInfo.getGamerId()==2){
//                Map<Object, Object> gamerMap = new GamerDTO().gamerInfo(gInfo);
//                System.out.println(gamerMap);
//            }
        }
//        System.out.println(s.getGameInfo());
//
//        GamerInfo_Bean gamerInfoBean = new GamerInfo_Bean();
//        GameInfo_Bean g = new GameInfo_Bean();
//        Specs_Bean s = new Specs_Bean();
//
//        s.setProcessor("i13");
//        s.setRam("32gb");
//        s.setGraphicsCard("titan x");
//
//        g.setGameId(10);
//        g.setGameName("r6s");
//        g.setPublisher("ubi");
//        g.setLaunchDate("2012");
//        g.setVersion("2.2");
//        g.setSpecs(s);
//
//        gamerInfoBean.setGamerId(1);
//        gamerInfoBean.setGamerFName("osama");
//        gamerInfoBean.setGamerLName("jamil");
//        gamerInfoBean.setEmailAddress("asb@skj.sad");
//        gamerInfoBean.setGender("male");
//
//        gamerInfoBean.setGameInfo(g);
//
//
//        NewDTO gDTO = new NewDTO();
//
//        Map<Object,Object> test_obj_1 = gDTO.gamerInfo(gamerInfoBean);
//        List<JSONObject> a = new ArrayList<>();
//
//        JSONObject p1 = new JSONObject(test_obj_1);
//        a.add(p1);
//
//        new GamerManager().saveGamerFile(a);
}
