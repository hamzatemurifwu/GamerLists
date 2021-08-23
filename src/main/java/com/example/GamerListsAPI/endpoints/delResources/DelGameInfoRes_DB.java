package com.example.GamerListsAPI.endpoints.delResources;

import com.example.GamerListsAPI.controller.responses.DeleteResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/delgamedb")
@Api("/Games")
@SwaggerDefinition(tags = {@Tag(name = "Game Resource", description = "Information Related to Game Resources")})
public class DelGameInfoRes_DB {
    @DELETE
    @Path("/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete Game by Id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response delGamerby_ID(
            @ApiParam(value = "Game ID", required = true, defaultValue = "1")
            @PathParam("gameId") Integer gameId) throws SQLException {
        DeleteResponse delGamerResponse = new DeleteResponse();

        return delGamerResponse.delGameInfo_byId(gameId);
    }
}
