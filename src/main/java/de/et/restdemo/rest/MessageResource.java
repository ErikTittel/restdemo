package de.et.restdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Simple MessageResource
 *
 * Created by Erik on 24.10.2015.
 */
@Path("/message")
public class MessageResource {

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Restful example: " + msg;

        return Response.status(200).entity(result).build();
    }

    @GET
    public Response simpleResponse() {
        return Response.status(200).entity("Simple Text").build();
    }
}
