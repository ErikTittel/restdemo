package de.et.restdemo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
    @Produces("application/json")
    public Response simpleResponse() {
        return Response.status(200).entity(new Person("John", 35)).build();
    }

    @XmlRootElement
    class Person {

        @XmlElement
        String name;
        @XmlElement
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
