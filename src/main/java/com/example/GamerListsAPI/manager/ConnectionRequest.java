package com.example.GamerListsAPI.manager;

import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;
import com.example.GamerListsAPI.controller.DBConnection;

public class ConnectionRequest {
    public RequestConnectionDetails connectionRequest() {
        DBConnection cnn = new DBConnection();
        RequestConnectionDetails rq = new RequestConnectionDetails();
        rq.setDbConnection(cnn.getDBConn());

        return rq;
    }
}
