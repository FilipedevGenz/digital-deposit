package com.filipedevgenz.mssalas.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_deposit")
@Getter
@Setter
public class Deposit {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "deposit_id")
        UUID depositId;

        @NotNull
        @NotEmpty
        String name;

        @NotNull
        @NotEmpty
        String Local;

        @OneToMany(mappedBy = "deposit")
        Set<@Valid Thing> things;
}
