package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllnessDTO {
    private Long id;
    private String name;
    private String description;
    private String treatment;
    private Date diagnosingDate;
}
