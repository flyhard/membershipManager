package com.abich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import java.net.URL;

/**
 * Created by h76 on 10.12.2014.
 */
public class MembershipManagerConfiguration extends Configuration {
    @JsonProperty
    private URL couchDbUrl;
    @NotEmpty
    @JsonProperty
    private String dbName;

    public MembershipManagerConfiguration() {
    }

    public MembershipManagerConfiguration(final URL couchDbUrl) {
        this.couchDbUrl = couchDbUrl;
    }

    public URL getCouchDbUrl() {
        return couchDbUrl;
    }

    public String getDbName() {
        return dbName;
    }
}
