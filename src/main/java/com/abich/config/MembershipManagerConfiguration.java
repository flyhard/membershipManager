package com.abich.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MembershipManagerConfiguration extends Configuration {

    @Valid
    @NotNull
    private DbConfigurationServiceFactory db;

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
}
