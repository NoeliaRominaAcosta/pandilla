package com.api.pandilla.services;

import com.api.pandilla.models.PetModel;
import com.api.pandilla.repositories.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class PetService {
    @Autowired
    IPetRepository petRepository;

    public ArrayList<PetModel> getPets(){
        return (ArrayList<PetModel>) petRepository.findAll();
    }

    public PetModel savePet(PetModel pet){
        return petRepository.save(pet);
    }

    public Optional<PetModel> getById(Long id){
        return petRepository.findById(id);
    }

    public PetModel updateById(PetModel request, Long id) {
        Optional<PetModel> optionalPet = petRepository.findById(id);

        if (optionalPet.isPresent()) {
            PetModel pet = optionalPet.get();

            pet.setName(request.getName());
            pet.setAge(request.getAge());
            pet.setAdoptedBy(request.getAdoptedBy());
            pet.setAdoptedDate(request.getAdoptedDate());
            pet.setIllnesses(request.getIllnesses());
            pet.setArrivalDate(request.getArrivalDate());
            pet.setVaccination(request.getVaccination());
            pet.setHealthCondition(request.getHealthCondition());

            petRepository.save(pet);
            return pet;
        } else {
            // Manejar el caso en el que no se encontró la mascota con el ID proporcionado
            throw new NoSuchElementException("Pet with ID " + id + " not found");
        }
    }


    public Boolean deleteById(Long id){
        try {
            petRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
