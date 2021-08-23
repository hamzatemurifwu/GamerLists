package com.example.GamerListsAPI.endpoints.readResources;

import com.example.GamerListsAPI.beans.GameInfo_Bean;
import com.example.GamerListsAPI.controller.responses.ReadResponse;
import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/gamejs")
@Api("/Games")
@SwaggerDefinition(tags = {@Tag(name = "Game Resource", description = "Information Related to Game Resources")})
public class ReadGameRes_JSON {
    @GET
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Return Game by Id from Json Data Source")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = GameInfo_Bean.class))
    public Response getGame_JSON(
            @ApiParam(value = "Game ID", required = true, defaultValue = "1")
            @PathParam("gameId") Integer id) throws SQLException, IOException {
        ReadResponse gamer_response = new ReadResponse();

        return gamer_response.gameResponse_JSON(id);
    }
}
