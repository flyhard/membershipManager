package com.abich.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.hibernate.validator.constraints.NotEmpty;

@JsonTypeName("mongo")
public class DbConfigurationFactory implements DbConfigurationServiceFactory {


    @NotEmpty
    String host;
    @NotEmpty
    String name;
    @NotEmpty
    Integer port;

    @Override
    public DbConfigurationService build() {
        return new MongoDbConfigurationService();
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
