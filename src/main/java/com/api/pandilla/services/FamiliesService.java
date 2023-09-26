package com.api.pandilla.services;

import com.api.pandilla.models.Families;
import com.api.pandilla.repositories.IFamiliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FamiliesService {
    @Autowired
    IFamiliesRepository familiesRepository;

    public ArrayList<Families> getAllFams() { return (ArrayList<Families>)familiesRepository.findAll(); }
    public Families savefamily(Families families){ return familiesRepository.save(families);}
    public Optional<Families> getFamById(Long id){ return familiesRepository.findById(id);}
    public Families updateFamById(Families request, Long id){
        Families family = familiesRepository.findById(id).get();
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
