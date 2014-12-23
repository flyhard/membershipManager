package com.abich.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.mongojack.ObjectId;

/**
 * Created by perab_000 on 11.12.2014.
 */
public class Member {
    @JsonProperty
    @ObjectId
    private String id;
    @Length(min = 2)
    @JsonProperty
    private String name;

    public Member() {
    }

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }
}
