package com.api.pandilla.services;

import com.api.pandilla.models.PetModel;
import com.api.pandilla.models.Vaccine;
import com.api.pandilla.repositories.IVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VaccineService {
    @Autowired
    IVaccineRepository VaccineRepository;

    public ArrayList<Vaccine> getVaccines() {
        return (ArrayList<Vaccine>) VaccineRepository.findAll();
    }

    public Optional<Vaccine> getVaccineById(Long id) {
        return VaccineRepository.findById(id);
    }
    public Vaccine saveVaccine(Vaccine vaccine) {
        return VaccineRepository.save(vaccine);
    }

    public Vaccine updateById(Vaccine request, Long id) {
        Optional<Vaccine> optionalVaccine = VaccineRepository.findById(id);

        if (optionalVaccine.isPresent()) {
            Vaccine vaccine = optionalVaccine.get();

            vaccine.setName(request.getName());
            vaccine.setDose(request.getDose());
            vaccine.setNextApplication(request.getNextApplication());


            VaccineRepository.save(vaccine);
            return vaccine;
        } else {

            throw new NoSuchElementException("vaccine with ID " + id + " not found");
        }
    }
    public Boolean deleteById(Long id){
        try {
            VaccineRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
