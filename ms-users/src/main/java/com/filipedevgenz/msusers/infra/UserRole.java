package com.filipedevgenz.msusers.infra;

import lombok.Getter;

@Getter
public enum UserRole {
    VIP("vip"),
    USER("user");
    String role;

    private UserRole(final String role) {
        this.role = role;
    }

}
