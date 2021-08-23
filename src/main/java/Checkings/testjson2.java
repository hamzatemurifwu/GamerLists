package Checkings;

import com.example.GamerListsAPI.beans.testbeans.B1;
import com.example.GamerListsAPI.dto.GamerDTO;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.manager.DataSourceRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class testjson2 {
    public Map<Object, Object> getGamer_byID(Integer id, RequestConnectionDetails connectionDetails) {
        String contentFile = connectionDetails.getDataSource();
        Map<Object, Object> gamerMap = null;

        //Map<Object, Object> gamerMap = null;
        Type type = new TypeToken<List<B1>>() {
        }.getType();
        List<B1> fromJson = new Gson().fromJson(contentFile, type);


        for (B1 gInfo:fromJson) {
            if (gInfo.getGamerId()==id){
                gamerMap = new GamerDTO().gamerInfo(gInfo);
                break;
            }
        }
        return gamerMap;
    }

    public static void main(String[] args) {
        testjson2 gamerInfo = new testjson2();
        DataSourceRequest dsR = new DataSourceRequest();

        Map<Object, Object> gamerMap = gamerInfo.getGamer_byID(1, dsR.dataSourceRequest());

        System.out.println(JSONObject.toJSONString(gamerMap));
    }
}
