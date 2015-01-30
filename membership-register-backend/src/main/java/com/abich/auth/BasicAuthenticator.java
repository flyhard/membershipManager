package com.abich.auth;

import com.abich.core.Role;
import com.abich.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by abichper on 19.01.2015.
 */
public class BasicAuthenticator implements io.dropwizard.auth.Authenticator<io.dropwizard.auth.basic.BasicCredentials, com.abich.core.User> {
    private final String adminUsername;
    private final String adminPassword;

    public BasicAuthenticator(final String adminUsername, final String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    @Override
    public Optional<User> authenticate(final BasicCredentials credentials) throws AuthenticationException {
        if (credentials.getUsername().toLowerCase().equals(adminUsername.toLowerCase())) {
            if (credentials.getPassword().toLowerCase().equals(adminPassword)) {
                return Optional.of(new User("admin", Role.ADMIN));
            } else {
                throw new AuthenticationException("Login failed");
            }
        }
        if (validUserPassword(credentials.getUsername(), credentials.getPassword())) {
            return Optional.of(new User("anon", Role.ANONYMOUS));
        }
        return Optional.absent();
    }

    private boolean validUserPassword(String username, String adminPassword) {
        return true;
    }
}
