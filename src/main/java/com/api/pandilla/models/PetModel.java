package com.api.pandilla.models;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
@Data
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToMany
    @JoinTable(
            name = "pet_illness",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "illness_id")
    )
    private Set<Illness> illnesses = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "pet_vaccine",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private Set<Vaccine> vaccines;
    private Date arrivalDate;
    private Date adoptedDate;
    private String healthCondition;
    private String adoptedBy;
    private Boolean dewormed;
    private Boolean castration;
    private Date birthDate;
    private Date vetVisitDate;
    @Column(name = "medical_record_id")
    private Long medicalRecordId;
    @ManyToMany
    @JoinTable(
            name = "pet_family",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id")
    )
    private Set<Family> family = new HashSet<>();
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    public String encodeImage(byte[] imageBytes) {
        return Base64.encodeBase64String(imageBytes);
    }

    public byte[] decodeImage(String base64Image) {
        return Base64.decodeBase64(base64Image);
    }
}
