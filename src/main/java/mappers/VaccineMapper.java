package mappers;

import com.api.pandilla.models.Vaccine;
import dto.VaccineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccineMapper {
    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    VaccineDTO toVaccineDTO(Vaccine vaccine);

    Vaccine toVaccine(VaccineDTO vaccineDTO);
}
