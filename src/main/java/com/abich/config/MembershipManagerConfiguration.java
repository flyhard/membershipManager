package com.abich.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MembershipManagerConfiguration extends Configuration {

    @Valid
    @NotNull
    private DbConfigurationServiceFactory dbConfigurationServiceFactory;

    public MembershipManagerConfiguration() {
    }

    @JsonProperty("dbConfigurationService")
    public DbConfigurationServiceFactory getDbConfigurationServiceFactory() {
        return dbConfigurationServiceFactory;
    }

    @JsonProperty("dbConfigurationService")
    public void setDbConfigurationServiceFactory(final DbConfigurationServiceFactory dbConfigurationServiceFactory) {
        this.dbConfigurationServiceFactory = dbConfigurationServiceFactory;
    }
}
