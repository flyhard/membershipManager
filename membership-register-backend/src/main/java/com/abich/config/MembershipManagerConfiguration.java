package com.abich.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MembershipManagerConfiguration extends Configuration {

    @Valid
    @NotNull
    private DbConfigurationServiceFactory db;

    @Valid
    @NotNull
    private String adminUsername, adminPassword;

    public MembershipManagerConfiguration() {
    }

    @JsonProperty("db")
    public DbConfigurationServiceFactory getDbConfigurationServiceFactory() {
        return db;
    }

    @JsonProperty("db")
    public void setDbConfigurationServiceFactory(final DbConfigurationServiceFactory dbConfigurationServiceFactory) {
        this.db = dbConfigurationServiceFactory;
    }

    @JsonProperty("adminPassword")
    public String getAdminPassword() {
        return adminPassword;
    }

    @JsonProperty("adminUsername")
    public String getAdminUsername() {
        return adminUsername;
    }
}
