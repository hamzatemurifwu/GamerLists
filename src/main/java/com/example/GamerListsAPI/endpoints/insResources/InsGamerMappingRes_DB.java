package com.example.GamerListsAPI.endpoints.insResources;

import com.example.GamerListsAPI.controller.responses.InsertResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/insgamersmappingdb")
@Api("/Gamers Mapping")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class InsGamerMappingRes_DB {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{gamerId}")
    @ApiOperation(value = "Insert Gamers/Games Mapping info")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response insGamerMapping_DB(
            @ApiParam(value = "Gamer Id", required = true, defaultValue = "1")
            @PathParam("gamerId") Integer gamerId,
            @ApiParam(value = "Game Id", required = true, defaultValue = "1")
            @FormParam("gameId") Integer gameId) throws SQLException {
        InsertResponse insertResponse = new InsertResponse();

        return insertResponse.insertGamerMappingInfo(gamerId, gameId);
    }
}
