package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.assertj.core.util.Lists;
import org.hibernate.validator.constraints.Length;
import org.mongojack.ObjectId;

import java.util.List;

/**
 * Created by perab_000 on 11.12.2014.
 */
public class Member {
    @JsonProperty("_id")
    @ObjectId
    private String id;
    @Length(min = 2)
    @JsonProperty
    private String name;
    @JsonProperty
    private EmailAddress emailAddress;
    @JsonProperty
    private List<EmailAddress> alternativeAddresses;

    public Member() {
        this(null, null);
    }

    public Member(String id, String name) {
        this(id, name, null, Lists.emptyList());
    }

    public Member(final String id, final String name, final EmailAddress emailAddress, final List<EmailAddress> alternativeAddresses) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.alternativeAddresses = alternativeAddresses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public List<EmailAddress> getAlternativeAddresses() {
        return alternativeAddresses;
    }
}
