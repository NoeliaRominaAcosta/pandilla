package com.api.pandilla.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = true)  // Relación opcional con Pet (puede no estar asociado a una mascota)
    private PetModel pet;

    private String type;  // Tipo de gasto (vacuna, alimentación, tratamiento, etc.)
    private Double amount;  // Monto del gasto
    private LocalDate date;  // Fecha del gasto
    private String description;  // Descripción del gasto

    // Getters y Setters
}

