package com.filipedevgenz.mssalas.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
        @Column(name = "deposit_id")
         String depositId;

        @NotEmpty
        String number;

        @NotEmpty
        String local;

        @OneToMany(mappedBy = "deposit",cascade = CascadeType.ALL, orphanRemoval = true)
        Set<@Valid Thing> things;

}
