package com.gynr.model;

import com.gynr.enums.RoleType;

public class User {

    String name;
    RoleType role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

}
