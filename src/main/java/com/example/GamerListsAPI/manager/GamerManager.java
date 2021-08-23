package com.example.GamerListsAPI.manager;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GamerManager {
    public void saveGamerFile(List<JSONObject> jsonObject) {
        try {
            FileWriter file = new FileWriter("D:/test.json");
            file.write(String.valueOf(jsonObject));
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

