package com.filipedevgenz.mssalas.repository;

import com.filipedevgenz.mssalas.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface DepositRepository extends JpaRepository<Deposit, String> {
    Optional<List<Deposit>> getDepositsByUserId(UUID userId);
}
