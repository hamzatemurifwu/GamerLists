package com.example.GamerListsAPI.manager;

import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.controller.ReadLinesJSON;

public class DataSourceRequest {
    public RequestConnectionDetails dataSourceRequest() {
        String filePath = "D:\\Sample-Projects\\test\\src\\main\\resources\\test.json";

        ReadLinesJSON lines = new ReadLinesJSON();
        RequestConnectionDetails rq = new RequestConnectionDetails();
        rq.setDataSource(lines.readLineByLineJson(filePath));

        return rq;
    }
}
