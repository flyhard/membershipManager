package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
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
    @Length(min = 1)
    @JsonProperty
    private String name;
    @JsonProperty
    private String emailAddress;
    @JsonProperty
    private List<EmailAddress> alternativeAddresses;

    @JsonProperty
    private String phone;

    public Member() {
        this(null, null);
    }

    public Member(String id, String name) {
        this(id, name, null, Lists.emptyList(), null);
    }

    public Member(final String id, final String name, final String emailAddress, final List<EmailAddress> alternativeAddresses, final String phone) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.alternativeAddresses = alternativeAddresses;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<EmailAddress> getAlternativeAddresses() {
        return alternativeAddresses;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("emailAddress", emailAddress)
                .add("alternativeAddresses", alternativeAddresses)
                .add("phone", phone)
                .toString();
    }
}
