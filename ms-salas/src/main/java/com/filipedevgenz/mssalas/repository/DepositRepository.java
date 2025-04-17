package com.filipedevgenz.mssalas.repository;

import com.filipedevgenz.mssalas.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepositRepository extends JpaRepository<Deposit, UUID> {
}
