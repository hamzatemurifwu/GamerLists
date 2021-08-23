package com.example.GamerListsAPI.endpoints.delResources;

import com.example.GamerListsAPI.controller.responses.DeleteResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/delgamersmappingdb")
@Api("/Gamers Mapping")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class DelGamerMappingRes_DB {
    @DELETE
    @Path("/{gamerId}/{gameId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete Gamers/Games Mapping info")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response insGamerMapping_DB(
            @ApiParam(value = "Gamer Id", required = true, defaultValue = "1")
            @PathParam("gamerId") Integer gamerId,
            @ApiParam(value = "Game Id", required = true, defaultValue = "1")
            @PathParam("gameId") Integer gameId) throws SQLException {
        DeleteResponse delGamerResponse = new DeleteResponse();

        return delGamerResponse.delGamerMappingInfo(gamerId, gameId);
    }
}
