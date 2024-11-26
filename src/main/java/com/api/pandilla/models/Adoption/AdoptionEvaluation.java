package com.api.pandilla.models.Adoption;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AdoptionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private AdoptionApplication application;

    private String evaluatorName;
    private String comments;
    private boolean approved;

    private LocalDate evaluationDate;
}

