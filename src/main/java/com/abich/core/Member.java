package com.abich.core;

import org.hibernate.validator.constraints.Length;

/**
 * Created by perab_000 on 11.12.2014.
 */
public class Member {
    private long id;
    @Length(min=2)
    private String name;

    public Member() {
    }

    public Member(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
