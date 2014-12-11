package com.abich;

import com.abich.core.Member;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.google.common.base.Optional;

/**
 * Created by perab_000 on 11.12.2014.
 */
@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    public MemberResource() {
    }

    @GET
    @Timed
    public Member getMember(@QueryParam("id") Optional<Long> id) {
        return new Member(id.or(0l), "NoName");
    }
}
