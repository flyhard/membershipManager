package com.abich.core;

import java.util.List;

/**
 * Created by abichper on 19.01.2015.
 */
public class User {
    private final String username;
    private final Role role;

    public User(final String username, final Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public boolean hasRole(Role role) {
        return this.role == role;
    }

    public boolean hasPrivilege(Privilege privilege) {
        return role.containsPrivilege(privilege);
    }

    public List<Privilege> getPrivileges() {
        return role.getPrivileges();
    }
}
