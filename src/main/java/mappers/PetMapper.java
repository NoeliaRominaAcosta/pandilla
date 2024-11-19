package mappers;

import com.api.pandilla.models.Family;
import com.api.pandilla.models.Illness;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.models.Vaccine;
import dto.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    @Mapping(source = "illnesses", target = "illnesses", qualifiedByName = "illnessesToStringSet")
    @Mapping(source = "vaccines", target = "vaccines", qualifiedByName = "vaccinesToStringSet")
    @Mapping(source = "family", target = "familyIds", qualifiedByName = "familyToIdSet")
    PetDTO petModelToPetDTO(PetModel petModel);

    @Mapping(source = "illnesses", target = "illnesses", qualifiedByName = "stringSetToIllnesses")
    @Mapping(source = "vaccines", target = "vaccines", qualifiedByName = "stringSetToVaccines")
    @Mapping(source = "familyIds", target = "family", qualifiedByName = "idSetToFamily")
    PetModel petDTOToPetModel(PetDTO petDTO);

    @Named("illnessesToStringSet")
    default Set<String> illnessesToStringSet(Set<Illness> illnesses) {
        return illnesses.stream()
                .map(Illness::getName)  // Asumiendo que Illness tiene un método getName()
                .collect(Collectors.toSet());
    }

    @Named("vaccinesToStringSet")
    default Set<String> vaccinesToStringSet(Set<Vaccine> vaccines) {
        return vaccines.stream()
                .map(Vaccine::getName)  // Asumiendo que Vaccine tiene un método getName()
                .collect(Collectors.toSet());
    }

    @Named("familyToIdSet")
    default Set<Long> familyToIdSet(Set<Family> families) {
        return families.stream()
                .map(Family::getId)  // Asumiendo que Family tiene un método getId()
                .collect(Collectors.toSet());
    }

    @Named("stringSetToIllnesses")
    default Set<Illness> stringSetToIllnesses(Set<String> illnessNames) {
        return illnessNames.stream()
                .map(name -> {
                    Illness illness = new Illness();
                    illness.setName(name);  // Asumiendo que Illness tiene un método setName()
                    return illness;
                })
                .collect(Collectors.toSet());
    }

    @Named("stringSetToVaccines")
    default Set<Vaccine> stringSetToVaccines(Set<String> vaccineNames) {
        return vaccineNames.stream()
                .map(name -> {
                    Vaccine vaccine = new Vaccine();
                    vaccine.setName(name);  // Asumiendo que Vaccine tiene un método setName()
                    return vaccine;
                })
                .collect(Collectors.toSet());
    }

    @Named("idSetToFamily")
    default Set<Family> idSetToFamily(Set<Long> familyIds) {
        return familyIds.stream()
                .map(id -> {
                    Family family = new Family();
                    family.setId(id);  // Asumiendo que Family tiene un método setId()
                    return family;
                })
                .collect(Collectors.toSet());
    }
}
