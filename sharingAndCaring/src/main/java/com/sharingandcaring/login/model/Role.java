package com.sharingandcaring.login.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by sharingandcaring on 1/2/16.
 */
public class Role implements GrantedAuthority {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return this.name;
    }
}
