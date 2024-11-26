package com.api.pandilla.models.Adoption;

import com.api.pandilla.models.Family;
import com.api.pandilla.models.PetModel;
import dto.FamilyDTO;
import lombok.Data;
import utils.ApplicationStatus;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class AdoptionApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetModel pet;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "adopter_email", nullable = false)
    private String adopterEmail;

    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @Column(name = "adopter_notes")
    private String adopterNotes;
}
//TODO:
/*
* Resumen del Flujo Completo
Postulación:

Un adoptante llena un formulario y selecciona una mascota.
Se registra una solicitud en estado "Pendiente".
Evaluación:

Un evaluador revisa la solicitud.
Se aprueba o rechaza, con comentarios asociados.
Contrato de Adopción:

Si la solicitud es aprobada, se genera un contrato.
La mascota pasa a estado "Adoptada".
Seguimiento:

Se realizan visitas periódicas para asegurar el bienestar de la mascota.
Se registran observaciones y el progreso del adoptante.
* */