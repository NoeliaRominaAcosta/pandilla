package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonationDTO {

    private Double amount;
    private LocalDate date;
    private String description;
    private Long familyId;  // ID de la familia adoptante (opcional)

    // Getters y Setters
}
