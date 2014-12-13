package com.abich;

import com.abich.core.Member;
import com.abich.db.MemberRepository;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    private final MemberRepository memberRepository;

    public MemberResource(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GET
    @Path("/{id}")
    @Timed
    public Member getMember(@PathParam("id") String id) {
        Member member = memberRepository.get(id);
        return member;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Member createMember(@Valid Member member){
        memberRepository.add(member);
        return member;
    }
}
