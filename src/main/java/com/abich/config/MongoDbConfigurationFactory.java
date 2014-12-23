package com.abich.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@JsonTypeName("mongo")
public class MongoDbConfigurationFactory implements DbConfigurationServiceFactory {


    @NotEmpty
    String host;
    @NotEmpty
    String name;
    @NotNull
    Integer port;

    @Override
    public DbConfigurationService build() {
        return new MongoDbConfigurationService(name, host, port);
    }

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public void setHost(final String host) {
        this.host = host;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty
    public Integer getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(final Integer port) {
        this.port = port;
    }
}
