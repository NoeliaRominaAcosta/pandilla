package mappers;

import com.api.pandilla.models.Illness;
import dto.IllnessDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IllnessMapper {

    IllnessMapper INSTANCE = Mappers.getMapper(IllnessMapper.class);

    IllnessDTO illnessToIllnessDTO(Illness illness);  // Convertir de entidad a DTO

    Illness illnessDTOToIllness(IllnessDTO illnessDTO);  // Convertir de DTO a entidad
}
