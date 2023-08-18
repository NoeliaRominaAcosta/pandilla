package com.api.pandilla.services;

import com.api.pandilla.models.Illness;
import com.api.pandilla.repositories.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IllnessService {

    @Autowired
    IllnessRepository repository;

    public ArrayList<Illness> getAllIllness(){
        return (ArrayList<Illness>)repository.findAll();
    }
    public Illness saveIllness(Illness illness) {
        return repository.save(illness);
    }
    public Optional<Illness> getIllnessById(Long id) {
        return repository.findById(id);
    }

    public Illness updateById(Illness request, Long id) {
        Illness illness = repository.findById(id).get();
       illness.setName(request.getName());
       illness.setDescription(request.getDescription());
       illness.setTreatment(request.getTreatment());
       illness.setDiagnosingDate(request.getDiagnosingDate());
       repository.save(illness);
       return illness;
    }

    public Boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
