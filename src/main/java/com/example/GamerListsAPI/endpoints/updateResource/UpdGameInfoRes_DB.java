package com.example.GamerListsAPI.endpoints.updateResource;

import com.example.GamerListsAPI.controller.responses.UpdateResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/updgamedb")
@Api("/Games")
@SwaggerDefinition(tags = {@Tag(name = "Game Resource", description = "Information Related to Game Resources")})
public class UpdGameInfoRes_DB {
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{gameId}")
    @ApiOperation(value = "Update Game by Id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response updGameInfo_DB(
            @ApiParam(value = "Game ID", required = true, defaultValue = "1")
            @PathParam("gameId") Integer gameId,
            @ApiParam(value = "Game Name", required = true)
            @FormParam("gameName") String gameName,
            @ApiParam(value = "Publisher", required = true)
            @FormParam("publisher") String publisher,
            @ApiParam(value = "Launch Date", required = true)
            @FormParam("launchDate") String launchDate,
            @ApiParam(value = "Version", required = true)
            @FormParam("version") String version,
            @ApiParam(value = "Processor", required = true)
            @FormParam("processor") String processor,
            @ApiParam(value = "Ram", required = true)
            @FormParam("ram") String ram,
            @ApiParam(value = "Graphics Card", required = true)
            @FormParam("graphicsCard") String graphicsCard) throws SQLException {

        UpdateResponse updateResponse = new UpdateResponse();

        return updateResponse.updateGameInfo(gameId,gameName,publisher,launchDate,version,processor,ram,graphicsCard);
    }
}





