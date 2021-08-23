package com.example.GamerListsAPI.endpoints.updateResource;

import com.example.GamerListsAPI.controller.responses.UpdateResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/updgamersdb")
@Api("/Gamers")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class UpdGamerInfoRes_DB {
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{gamerId}")
    @ApiOperation(value = "Update Gamer by Id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response updGamerInfo_DB(
            @ApiParam(value = "Gamer Id", required = true, defaultValue = "1")
            @PathParam("gamerId") Integer id,
            @ApiParam(value = "First Name", required = true)
            @FormParam("fName") String fName,
            @ApiParam(value = "Last Name", required = true)
            @FormParam("lname") String lName,
            @ApiParam(value = "Email", required = true)
            @FormParam("email") String email,
            @ApiParam(value = "Gender", required = true)
            @FormParam("gender") String gender) throws SQLException {
        UpdateResponse updateResponse = new UpdateResponse();

        return updateResponse.updateGamersInfo(id,fName,lName,email,gender);
    }
}
