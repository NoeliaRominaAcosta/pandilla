package mappers;

import com.api.pandilla.models.MedicalRecord;
import dto.MedicalRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {

    @Mapping(source = "pet.id", target = "petId")
    MedicalRecordDTO toDTO(MedicalRecord medicalRecord);

    @Mapping(source = "petId", target = "pet.id")
    MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO);
}
