package com.abich.resources;

import com.abich.core.User;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.auth.Auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    @Timed
    @Path("/privileges")
    public User getUserPrivileges(@Auth(required = false) User user) {
        return user;
    }
}
