package com.api.pandilla.models.Adoption;
import utils.ContractStatus;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class AdoptionContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AdoptionApplication application;

    private LocalDate adoptionDate;
    private String contractFilePath; // Ruta al archivo PDF o documento firmado.

    @Enumerated(EnumType.STRING)
    private ContractStatus status; // SIGNED, PENDING, CANCELLED
}
