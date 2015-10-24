package de.et.restdemo.rest;

import de.et.restdemo.model.User;
import de.et.restdemo.model.UserId;
import de.et.restdemo.utils.KeyGen;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * REST resource that provides access to a User.
 *
 * Created by Erik on 24.10.2015.
 */
@Path("/user")
public class UserResource {

    private Map<String, User> usersById = new HashMap<>();

    @GET
    @Produces("application/json")
    public Response simpleResponse() {
        return Response.status(200).entity(new User("1234", "John", "john@mail.com", 35)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response saveUser(User user) {
        String id = KeyGen.getKey();
        user.setId(id);
        usersById.put(id, user);

        return Response.status(201).entity(new UserId(id)).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") String id) {
        User user = usersById.get(id);
        return Response.status(201).entity(user).build();
    }
}
