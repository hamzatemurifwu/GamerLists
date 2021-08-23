package Checkings;

import com.example.GamerListsAPI.beans.GamerInfo_Bean;
import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.beans.Specs_Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class testjson {
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
    public FileReader abc(){
        try {
            FileReader reader = new FileReader("D:/Gamers.json");
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        JsonElement jsonElement;

        FileReader reader = new FileReader("D:/Gamers.json");

        JsonElement root = new JsonParser().parse(reader);

        JsonObject a = root.getAsJsonArray().get(0).getAsJsonObject();

        Map<Object,Object> gamerMap =
                new ObjectMapper().readValue(a.toString(), HashMap.class);

        Map<Object,Object> gameInfo_Map = (Map<Object, Object>) gamerMap.get("Game Info");

        Map<Object,Object> specs_Map = (Map<Object, Object>) gameInfo_Map.get("Specs");

        JsonElement jsonElement1 = new Gson().toJsonTree(gamerMap);
        List gList1 = (Collections.singletonList(jsonElement1.getAsJsonObject()));
        JsonElement jsonElement2 = new Gson().toJsonTree(gameInfo_Map);
        List gList2 = (Collections.singletonList(jsonElement2.getAsJsonObject()));
        JsonElement jsonElement3 = new Gson().toJsonTree(specs_Map);
        List gList3 = (Collections.singletonList(jsonElement3.getAsJsonObject()));

        Type type1 = new TypeToken<List<GamerInfo_Bean>>() {}.getType();
        Type type2 = new TypeToken<List<GameInfo_Bean>>() {}.getType();
        Type type3 = new TypeToken<List<Specs_Bean>>() {}.getType();

        List<GamerInfo_Bean> fromJson1 = new Gson().fromJson(gList1.toString(), type1);
        List<GameInfo_Bean> fromJson2 = new Gson().fromJson(gList2.toString(), type2);
        List<Specs_Bean> fromJson3 = new Gson().fromJson(gList3.toString(), type3);

        System.out.println(fromJson1.get(0).getGamerFName());
        System.out.println(fromJson2.get(0).getGameName());
        System.out.println(fromJson3.get(0).getProcessor());

    }
}
