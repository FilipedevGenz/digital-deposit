package com.filipedevgenz.mssecurity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "usersSecurity_tb")
public class Users {
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String mail;
    private String encondedPassword;
    private String roles;
}
