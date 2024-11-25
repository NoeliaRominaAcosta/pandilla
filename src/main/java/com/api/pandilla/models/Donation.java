package com.api.pandilla.models;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = true)  // Relación con la familia adoptante (opcional)
    private Family family;  // Este modelo representaría a la familia adoptante

    private Double amount;  // Monto de la donación
    private LocalDate date;  // Fecha de la donación
    private String description;  // Descripción de la donación

    // Getters y Setters
}

