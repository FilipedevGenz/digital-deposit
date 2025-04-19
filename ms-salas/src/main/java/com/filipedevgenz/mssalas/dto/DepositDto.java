package com.filipedevgenz.mssalas.dto;

import jakarta.validation.constraints.NotEmpty;

public record DepositDto(

        @NotEmpty
        String number,
        @NotEmpty
        String local
)
{}
