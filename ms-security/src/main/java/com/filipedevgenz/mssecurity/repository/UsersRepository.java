package com.filipedevgenz.mssecurity.repository;

import com.filipedevgenz.mssecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM Users u WHERE LOWER(u.mail) = LOWER(?1)")
    Users findByEmailIgnoreCase(String email);
}
