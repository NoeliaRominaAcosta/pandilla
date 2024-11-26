package com.api.pandilla.services;

import com.api.pandilla.models.Family;
import com.api.pandilla.repositories.IFamilyRepository;
import dto.FamilyDTO;
import mappers.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FamilyService {
    @Autowired
    private IFamilyRepository familiesRepository;
    @Autowired
    private FamilyMapper familyMapper;

    public List<FamilyDTO> getAllFams() {
        List<Family> families = familiesRepository.findAll();
        return families.stream().map(familyMapper::convertToDTO).collect(Collectors.toList());
    }

    public FamilyDTO saveFamily(FamilyDTO familyDTO) {
        Family family = familyMapper.convertToEntity(familyDTO);
        Family savedFamily = familiesRepository.save(family);
        return familyMapper.convertToDTO(savedFamily);
    }

    public Optional<FamilyDTO> getFamById(Long id) {
        return familiesRepository.findById(id).map(familyMapper::convertToDTO);
    }
    public Optional<Family> getFamilyById(Long id) {
        return familiesRepository.findById(id);
    }

    public FamilyDTO updateFamily(FamilyDTO request, Long id) {
        Family family = familiesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Family not found"));

        family.setName(request.getName());
        family.setLastName(request.getLastName());
        family.setDescription(request.getDescription());
        family.setEmail(request.getEmail());
        family.setPhone(request.getPhone());
        family.setLocation(request.getLocation());
        family.setTypeOfAdoption(request.getTypeOfAdoption());
        family.setContract(request.getContract());

        Family updatedFamily = familiesRepository.save(family);
        return familyMapper.convertToDTO(updatedFamily);
    }

    public Boolean deleteFamById(Long id) {
        try {
            familiesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}


