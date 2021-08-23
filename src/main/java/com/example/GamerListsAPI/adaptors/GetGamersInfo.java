package com.example.GamerListsAPI.adaptors;

import com.example.GamerListsAPI.dto.ReturnedObjects;
import com.example.GamerListsAPI.implementations.DB_Imp.RequestConnectionDetails;

import java.io.IOException;
import java.sql.SQLException;

public interface GetGamersInfo {
    ReturnedObjects getGamer_byID(Integer id,
                                  RequestConnectionDetails connectionDetails) throws IOException, SQLException;

    ReturnedObjects getGame_byID(Integer gameId,
                                 RequestConnectionDetails connectionDetails) throws IOException, SQLException;
}

