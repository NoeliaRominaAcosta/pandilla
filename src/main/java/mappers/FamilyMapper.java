package mappers;

import com.api.pandilla.models.Family;
import dto.FamilyDTO;
import org.springframework.stereotype.Component;

@Component
public class FamilyMapper {

    public FamilyDTO convertToDTO(Family family) {
        return new FamilyDTO(family.getId(), family.getName(), family.getLastName(),
                family.getDescription(), family.getEmail(), family.getLocation(),
                family.getPhone(), family.getTypeOfAdoption(), family.getContract());
    }

    public Family convertToEntity(FamilyDTO familyDTO) {
        Family family = new Family();
        family.setId(familyDTO.getId());
        family.setName(familyDTO.getName());
        family.setLastName(familyDTO.getLastName());
        family.setDescription(familyDTO.getDescription());
        family.setEmail(familyDTO.getEmail());
        family.setLocation(familyDTO.getLocation());
        family.setPhone(familyDTO.getPhone());
        family.setTypeOfAdoption(familyDTO.getTypeOfAdoption());
        family.setContract(familyDTO.getContract());
        return family;
    }
}
