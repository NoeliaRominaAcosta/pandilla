package com.api.pandilla.services;

import com.api.pandilla.models.Family;
import com.api.pandilla.repositories.IFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FamilyService {
    @Autowired
    IFamilyRepository familiesRepository;

    public ArrayList<Family> getAllFams() { return (ArrayList<Family>)familiesRepository.findAll(); }
    public Family savefamily(Family family){ return familiesRepository.save(family);}
    public Optional<Family> getFamById(Long id){ return familiesRepository.findById(id);}
    public Family updateFamById(Family request, Long id){
        Family family = familiesRepository.findById(id).get();
        family.setName(request.getName());
        family.setLastName(request.getLastName());
        family.setDescription(request.getDescription());
        family.setEmail(request.getEmail());
        family.setPhone(request.getPhone());
        family.setLocation(request.getLocation());
        family.setTypeOfAdoption(request.getTypeOfAdoption());
        family.setContract(request.getContract());
        familiesRepository.save(family);
        return family;
    }
    public Boolean deleteFamById(Long id){
        try {
            familiesRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
