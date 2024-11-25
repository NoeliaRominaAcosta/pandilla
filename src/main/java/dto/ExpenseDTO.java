package dto;

import com.api.pandilla.models.PetModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {

    private String type;
    private Double amount;
    private LocalDate date;
    private String description;
    private Long petId;  // ID de la mascota (opcional)

    // Getters y Setters
}

