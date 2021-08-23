package com.example.GamerListsAPI.endpoints.readResources;

import com.example.GamerListsAPI.beans.testbeans.B1;
import com.example.GamerListsAPI.controller.responses.ReadResponse;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Path("/gamersjs")
@Api("/Gamers")
@SwaggerDefinition(tags = {@Tag(name = "Gamer Resource", description = "Information Related to Gamer Resources")})
public class ReadGamerRes_JSON {
    @GET
    @Path("/{gamerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Return Gamer by Id from Json Data Source")
    @ApiResponses(value = @ApiResponse(code = 200, message = "Successful operation", response = B1.class))
    public Response getGamer_JSON(
            @ApiParam(value = "Gamer ID", required = true, defaultValue = "1")  @PathParam("gamerId") Integer id) throws SQLException, IOException {
        ReadResponse gamer_response = new ReadResponse();

        return gamer_response.gamerResponse_JSON(id);
    }
}
