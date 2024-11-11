package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {
    private Long id;
    private String name;
    private Integer dose;
    private String nextApplication;
}
