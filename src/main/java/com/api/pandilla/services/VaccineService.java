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
    IVaccineRepository vaccineRepository;

    public ArrayList<Vaccine> getVaccines() {
        return (ArrayList<Vaccine>) vaccineRepository.findAll();
    }

    public Optional<Vaccine> getVaccineById(Long id) {
        return vaccineRepository.findById(id);
    }

    public Vaccine saveVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public Vaccine updateById(Vaccine request, Long id) {
        Optional<Vaccine> optionalVaccine = vaccineRepository.findById(id);

        if (optionalVaccine.isPresent()) {
            Vaccine vaccine = optionalVaccine.get();
            vaccine.setName(request.getName());
            vaccine.setDose(request.getDose());
            vaccine.setNextApplication(request.getNextApplication());
            vaccineRepository.save(vaccine);
            return vaccine;
        } else {
            throw new NoSuchElementException("Vaccine with ID " + id + " not found");
        }
    }

    public Boolean deleteById(Long id) {
        try {
            vaccineRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
