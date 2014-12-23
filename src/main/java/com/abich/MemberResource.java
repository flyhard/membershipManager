package com.abich;

import com.abich.core.Member;
import com.abich.db.MemberRepository;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
        return memberRepository.get(id).get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Member createMember(@Valid Member member) {
        if (member.getId() != null && memberRepository.contains(member.getId())) {
            Member orgMember = memberRepository.get(member.getId()).get();
            orgMember.setName(member.getName());
            memberRepository.update(orgMember);
            member = orgMember;
        } else {
            memberRepository.add(member);
        }
        return member;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Timed
    public Member createMember(@Valid Member member, @PathParam("id") String id) {
        if (member.getId() != null && memberRepository.contains(id)) {
            Member orgMember = memberRepository.get(id).get();
            orgMember.setName(member.getName());
            memberRepository.update(orgMember);
            member = orgMember;
        } else {
            memberRepository.add(member);
        }
        return member;
    }
}
