package com.abich.core;

import com.google.common.collect.Lists;

import java.util.ArrayList;

import static com.abich.core.Privilege.*;

/**
 * Created by abichper on 20.01.2015.
 */
public enum Role {
    ADMIN(LIST_MEMBERS, MANAGE_MEMBERS, MANAGE_PAYMENT, EDIT_SELF), ANONYMOUS();
    private final ArrayList<Privilege> privileges;

    private Role(Privilege... privileges) {
        this.privileges = Lists.newArrayList(privileges);
    }

    public boolean containsPrivilege(final Privilege privilege) {
        return privileges.contains(privilege);
    }

    public ArrayList<Privilege> getPrivileges() {
        return privileges;
    }
}
