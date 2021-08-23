package com.example.GamerListsAPI.adaptors;

import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;

import java.sql.SQLException;

public interface UpdateGamersInfo {
    ReturnedObjects updateGamerInfo(Integer id,
                                    String fName,
                                    String lName,
                                    String email,
                                    String gender,
                                    RequestConnectionDetails connectionDetails) throws SQLException;
    ReturnedObjects updateGameInfo(Integer gameId,
                             String gameName,
                             String publisher,
                             String launchDate,
                             String version,
                             String processor,
                             String ram,
                             String graphicsCard,
                             RequestConnectionDetails connectionDetails) throws SQLException;
    ReturnedObjects updateGamerMappingInfo(Integer gamerId,
                                     Integer gameId_Old,
                                     Integer gameId_New,
                                     RequestConnectionDetails connectionDetails) throws SQLException;
}
