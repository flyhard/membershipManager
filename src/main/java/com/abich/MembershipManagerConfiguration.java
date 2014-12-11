package com.abich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by h76 on 10.12.2014.
 */
public class MembershipManagerConfiguration extends Configuration {
    @NotEmpty
    private String temp;

    @JsonProperty
    public String getTemp() {
        return temp;
    }

    @JsonProperty
    public void setTemp(String temp) {
        this.temp = temp;
    }
}
