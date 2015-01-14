package com.abich.core;

public class EmailAddressBuilder {
    private String email;

    public EmailAddressBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public EmailAddress createEmailAddress() {
        return new EmailAddress(email);
    }

    public EmailAddressBuilder clone(final EmailAddress emailAddress) {
        email = emailAddress.getEmail();
        return this;
    }

}