package com.abich.core;

public class EmailAddressBuilder {
    private String email;
    private boolean primary = false;

    public EmailAddressBuilder setEmail(final String email) {
        this.email = email;
        return this;
    }

    public EmailAddress createEmailAddress() {
        return new EmailAddress(email, primary);
    }

    public EmailAddressBuilder clone(final EmailAddress emailAddress) {
        email = emailAddress.getEmail();
        primary = emailAddress.isPrimary();
        return this;
    }

    public void setPrimary() {
        primary = true;
    }

    public void setAlternate() {
        primary = false;
    }
}