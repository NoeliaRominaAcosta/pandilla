package dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecordDTO {

    private Long id;
    private Long petId;
    private String diagnosis;
    private String treatment;
    private LocalDate visitDate;
    private String veterinarianName;

}