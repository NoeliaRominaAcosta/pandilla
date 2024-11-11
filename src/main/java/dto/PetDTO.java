package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Long id;
    private String name;
    private int age;
    private Set<String> illnesses; // Solo los nombres de las enfermedades
    private Set<String> vaccines;  // Solo los nombres de las vacunas
    private Date arrivalDate;
    private Date adoptedDate;
    private String healthCondition;
    private String adoptedBy;
    private Boolean dewormed;
    private Boolean castration;
    private Date birthDate;
    private Date vetVisitDate;
    private Set<Long> familyIds; // IDs de familias relacionadas para simplificar
    private String image; // Imagen codificada en Base64
}
