package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDTO {
    private Long id;
    private String name;
    private String lastName;
    private String description;
    private String email;
    private String location;
    private String phone;
    private String typeOfAdoption;
    private Boolean contract;

}
