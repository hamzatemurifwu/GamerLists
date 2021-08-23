package com.example.GamerListsAPI.endpoints.delResources;

import com.example.GamerListsAPI.controller.responses.DeleteResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/delgamersdb")
@Api("/Gamers")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class DelGamerInfoRes_DB {
    @DELETE
    @Path("/{gamerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Delete Gamer by Id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = String.class))
    public Response delGamerby_ID(
            @ApiParam(value = "Gamer ID", required = true, defaultValue = "1")
            @PathParam("gamerId") Integer gamerId) throws SQLException {
        DeleteResponse delGamerResponse = new DeleteResponse();

        return delGamerResponse.delGamersInfo_byId(gamerId);
    }
}
