package com.ajantha.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by ajantha on 1/2/16.
 */
public class Role  implements GrantedAuthority {
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
