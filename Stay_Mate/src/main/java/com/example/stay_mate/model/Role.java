package com.example.stay_mate.model;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");
    final String roleCode;

    Role(String roleCode) {
        this.roleCode=roleCode;
    }
}
