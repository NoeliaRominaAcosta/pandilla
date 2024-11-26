package dto;

import com.api.pandilla.models.Family;
import com.api.pandilla.models.PetModel;
import lombok.Data;
import utils.ApplicationStatus;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class AdoptionApplicationDTO {

    private PetModel pet;

    private Family family;


    private String adopterEmail;


    private LocalDate applicationDate;


    private ApplicationStatus status = ApplicationStatus.PENDING;


    private String adopterNotes;
}

