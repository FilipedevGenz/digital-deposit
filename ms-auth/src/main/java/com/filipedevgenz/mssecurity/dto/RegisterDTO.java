package com.filipedevgenz.mssecurity.dto;

import com.filipedevgenz.mssecurity.model.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
