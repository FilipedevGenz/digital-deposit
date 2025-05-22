package com.filipedevgenz.mssecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    VIP("admin"),
    COMMON("common");

    String role;
}
