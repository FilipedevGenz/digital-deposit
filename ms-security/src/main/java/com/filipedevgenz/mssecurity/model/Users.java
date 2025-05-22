package com.filipedevgenz.mssecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Setter
@Entity
@Table(name = "usersSecurity_tb")
public class Users implements UserDetails {
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private UUID id;
    private String mail;
    private String encondedPassword;
    private UserRole roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == UserRole.VIP) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_VIP"),
                    new SimpleGrantedAuthority("ROLE_COMMON")
            );
        }
        return List.of(new SimpleGrantedAuthority("ROLE_COMMON"));
    }

    @Override
    public String getPassword() {
        return encondedPassword;
    }

    @Override
    public String getUsername() {
        return mail;
    }
}
