package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;

/**
 * Created by abichper on 25.12.2014.
 */
public class EmailAddress {
    @JsonProperty
    @NotNull
    private String email;

    private boolean primary;

    public EmailAddress() {
    }

    public EmailAddress(final String email, final boolean primary) {
        this.email = email;
        this.primary = primary;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .toString();
    }

    public boolean isPrimary() {
        return primary;
    }
}
