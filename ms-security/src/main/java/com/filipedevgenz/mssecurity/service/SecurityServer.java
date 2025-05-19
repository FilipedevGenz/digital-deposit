package com.filipedevgenz.mssecurity.service;

import com.filipedevgenz.mssecurity.config.CustomAutentication;
import com.filipedevgenz.mssecurity.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityServer {
    private final UserService userService;

    public Users getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof CustomAutentication customAutentication) {
            return customAutentication.getUser();
        }
        return null;
    }

}
