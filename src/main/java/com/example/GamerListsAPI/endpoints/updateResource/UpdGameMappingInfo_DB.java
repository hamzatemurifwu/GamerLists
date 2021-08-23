package com.example.GamerListsAPI.endpoints.updateResource;

import com.example.GamerListsAPI.controller.responses.UpdateResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/updgamerMappingdb")
@Api("/Gamers Mapping")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class UpdGameMappingInfo_DB {
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{gamerId}/{gameId}")
    @ApiOperation(value = "Update Gamers/Games Mapping info")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response updGamerMappingInfo_DB(
            @ApiParam(value = "Gamer Id", required = true, defaultValue = "1")
            @PathParam("gamerId") Integer gamerId,
            @ApiParam(value = "Previous Gamer Id", required = true, defaultValue = "1")
            @PathParam("gameId") Integer gameId_Old,
            @ApiParam(value = "New Gamer Id", required = true, defaultValue = "1")
            @FormParam("gamerId_new") Integer gameId_New) throws SQLException {

        UpdateResponse updateResponse = new UpdateResponse();

        return updateResponse.updateGamerMappingInfo(gamerId,gameId_Old,gameId_New);
    }
}
