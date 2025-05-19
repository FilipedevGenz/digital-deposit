package com.filipedevgenz.mssalas.model;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "tb_deposit")
@Getter
@Setter
public class Deposit {

        @NotEmpty
        private String number;

        @NotEmpty
        private String local;

        @Id
        @Column(name = "deposit_id")
        private String depositId;

        private UUID userId;

        @OneToMany(mappedBy = "deposit",cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Thing> things = new HashSet<>();

        Deposit(String number, String local) {
                this.number = number;
                this.local = local;
        }

        @PrePersist
        public void prePersist() {
                if (depositId == null && local != null && number != null) {
                        this.depositId = local + number;
                }
        }
}
