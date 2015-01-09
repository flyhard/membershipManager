package com.abich;

import com.abich.core.EmailAddress;
import com.abich.core.EmailAddressBuilder;
import com.abich.core.Member;
import com.abich.core.MemberBuilder;
import com.abich.db.MemberRepository;
import com.codahale.metrics.annotation.Timed;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/member")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {
    public static final Logger LOGGER = LoggerFactory.getLogger(MemberResource.class);

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

    @GET
    @Timed
    public List<Member> getMember() {
        return memberRepository.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Member createMember(@Valid Member member) {
        if (member.getId() != null && memberRepository.contains(member.getId())) {
            Member orgMember = memberRepository.get(member.getId()).get();
            MemberBuilder memberBuilder = new MemberBuilder()
                    .clone(orgMember)
                    .setName(member.getName())
                    .cloneAlternativeAddresses(member.getAlternativeAddresses());
            Member member1 = memberBuilder.createMember();
            memberRepository.update(member1);
            member = member1;
        } else {
            EmailAddress emailAddress = new EmailAddressBuilder()
                    .setEmail("a@b").createEmailAddress();
            MemberBuilder memberBuilder = new MemberBuilder()
                    .clone(member)
                    .setName(member.getName())
                    .cloneAlternativeAddresses(Lists.newArrayList(emailAddress));
            Member member1 = memberBuilder.createMember();
            memberRepository.add(member1);
        }
        return member;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Timed
    public Member editMember(@Valid Member member, @PathParam("id") String id) {
        boolean newMember = false;
        if (member.getId() != null && memberRepository.contains(id)) {
            newMember = false;
            Optional<Member> memberOptional = memberRepository.get(id);
            Member dbMember = memberOptional.get();
            Member updatedMember = new MemberBuilder()
                    .clone(dbMember)
                    .setName(member.getName())
                    .setEmailAddress(member.getEmailAddress())
                    .setPhone(member.getPhone())
                    .cloneAlternativeAddresses(member.getAlternativeAddresses())
                    .createMember();
            LOGGER.debug("Updating member: {}",updatedMember);
            memberRepository.update(updatedMember);
            member = updatedMember;
        } else {
            newMember = true;
            memberRepository.add(member);
        }
        return member;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Timed
    public void deleteMember(@PathParam("id") String id) {
        memberRepository.delete(id);
    }
}
