package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by perab_000 on 11.12.2014.
 */
public class Member {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_rev")
    private String revision;
    @Length(min = 2)
    @JsonProperty
    private String name;

    public Member() {
    }

    public Member(String id, String revision, String name) {
        this.id = id;
        this.revision = revision;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRevision() {
        return revision;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public void setName(String name) {
        this.name = name;
    }
}
