package com.example.GamerListsAPI.endpoints.readResources;

import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.controller.responses.ReadResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/gamedb")
@Api("/Games")
@SwaggerDefinition(tags = {@Tag(name = "Game Resource", description = "Information Related to Game Resources")})
public class ReadGameRes_DB {
    @GET
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Return Game by Id from DataBase")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = GameInfo_Bean.class))
    public Response getGamerList_DB(
            @ApiParam(value = "Game ID", required = true, defaultValue = "1") @PathParam("gameId") Integer gameId) throws SQLException, IOException {
        ReadResponse gamer_response = new ReadResponse();

        return gamer_response.gameResponse_DB(gameId);
    }
}
