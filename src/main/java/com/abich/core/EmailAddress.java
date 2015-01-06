package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by abichper on 25.12.2014.
 */
public class EmailAddress {
    @JsonProperty
    @NotNull
    private String email;

    public EmailAddress() {
    }

    public EmailAddress(final String email) {

        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
