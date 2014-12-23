package com.abich.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.dropwizard.jackson.Discoverable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface DbConfigurationServiceFactory extends Discoverable {
    DbConfigurationService build();
}
