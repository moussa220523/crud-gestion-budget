package com.xarala.gestion_budget.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transaction")
public class Transaction {

    public enum TransactionType { REVENU, DEPENSE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TransactionType type;

    @NotNull
    private Double amount;

    @NotNull
    private LocalDate date;
}
