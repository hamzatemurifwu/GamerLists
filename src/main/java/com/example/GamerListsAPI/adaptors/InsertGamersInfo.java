package com.example.GamerListsAPI.adaptors;

import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;

import java.sql.SQLException;

public interface InsertGamersInfo {
    ReturnedObjects insertGamerInfo(Integer id,
                                    String fName,
                                    String lName,
                                    String email,
                                    String gender,
                                    RequestConnectionDetails connectionDetails) throws SQLException;

    ReturnedObjects insertGameInfo(Integer gameId,
                        String gameName,
                        String publisher,
                        String launchDate,
                        String version,
                        String processor,
                        String ram,
                        String graphicsCard,
                        RequestConnectionDetails connectionDetails) throws SQLException;

    ReturnedObjects insertGamersMapping(Integer gamerId, Integer gameId, RequestConnectionDetails connectionDetails);
}
