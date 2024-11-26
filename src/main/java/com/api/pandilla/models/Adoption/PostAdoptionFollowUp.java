package com.api.pandilla.models.Adoption;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class PostAdoptionFollowUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AdoptionContract contract;

    private LocalDate followUpDate;
    private String observations;
    private boolean isPetHealthy; // Estado general de la mascota.
    private boolean isAdoptantSatisfied; // Opinión del adoptante.
}
