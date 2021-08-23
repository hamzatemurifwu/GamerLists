package com.example.GamerListsAPI.adaptors;

import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;

import java.sql.SQLException;

public interface DeleteGamersInfo {
    ReturnedObjects delGamerInfo(Integer id,
                                 RequestConnectionDetails connectionDetails) throws SQLException;
    ReturnedObjects delGameInfo(Integer id,
                          RequestConnectionDetails connectionDetails) throws SQLException;
    ReturnedObjects delGamerMappingInfo(Integer gamerId,
                                  Integer gameId,
                                  RequestConnectionDetails connectionDetails) throws SQLException;
}
