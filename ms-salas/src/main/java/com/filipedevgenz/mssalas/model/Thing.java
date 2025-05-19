package com.filipedevgenz.mssalas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_thing")
@Getter
@Setter
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID thingId;

    @NotNull
    @NotEmpty
    String name;

    @DecimalMin(value = "0.0", inclusive = false)
    double quantity;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;
}
