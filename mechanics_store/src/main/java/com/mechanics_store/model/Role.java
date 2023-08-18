package com.mechanics_store.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Role that a user gets when he registers an account.
 *
 * @author Nebojsa Brankovic
 */
public enum Role implements GrantedAuthority {

    /**
     * Regular user (client) with limited functionalities
     */
    USER,
    /**
     * Worker that has all the functionalities
     */
    WORKER;

    @Override
    public String getAuthority() {
        return name();
    }
}
