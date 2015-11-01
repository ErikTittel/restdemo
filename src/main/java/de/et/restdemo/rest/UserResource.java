package de.et.restdemo.rest;

import de.et.restdemo.data.UserDao;
import de.et.restdemo.model.User;
import de.et.restdemo.model.UserResponse;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Provides access to a User through REST interface.
 *
 * <p>Created by Erik on 24.10.2015.
 */
@Path("/user")
public class UserResource {

    @Inject
    private UserDao dao;

    @GET
    @Produces("application/json")
    public Set<String> allUserIds() {
        return dao.getAllUserIds();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response saveUser(User user) {
        UserResponse response = new UserResponse();
        response.message = dao.saveUser(user);
        return Response.status(201).entity(response).build();
    }

    @PUT
    @Consumes("application/json")
    public Response updateUser(User user) {
        dao.updateUser(user);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") String id) {
        User user = dao.findUserById(id);
        if (user == null) {
            return Response.status(404).build();
        }
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        dao.deleteUserById(id);
        return Response.noContent().build();
    }
}
