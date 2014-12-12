package com.abich;

import com.abich.core.Member;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.common.base.Optional;

@Path("/member/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    public MemberResource() {
    }

    @GET
    @Timed
    public Member getMember(@PathParam("id") Long id) {
        return new Member(id, "NoName");
    }
}
