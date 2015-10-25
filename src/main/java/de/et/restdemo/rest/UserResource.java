package de.et.restdemo.rest;

import de.et.restdemo.data.UserDao;
import de.et.restdemo.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * REST resource that provides access to a User.
 *
 * Created by Erik on 24.10.2015.
 */
@Path("/user")
public class UserResource {

    private UserDao dao = UserDao.INSTANCE;

    @GET
    @Produces("application/json")
    public Set<String> simpleResponse() {
        return dao.getAllUserIds();
    }

    @POST
    @Consumes("application/json")
    public Response saveUser(User user) {
        String id = dao.saveUser(user);
        return Response.status(201).entity(id).build();
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
    public User getUser(@PathParam("id") String id) {
        return dao.findUserById(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        dao.deleteUserById(id);
        return Response.noContent().build();
    }
}
