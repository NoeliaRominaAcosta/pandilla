package com.api.pandilla.controllers;

import com.api.pandilla.models.PetModel;
import com.api.pandilla.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;
    @GetMapping
    public ArrayList<PetModel> getPets(){
        return this.petService.getPets();
    }

    @PostMapping
    public PetModel savePet(@RequestBody PetModel pet){
        return this.petService.savePet(pet);
    }


    @GetMapping(path = "/{id}")
    public Optional<PetModel> getPetById(@PathVariable Long id){
        return this.petService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public PetModel updatePet(@RequestBody PetModel request, @PathVariable("id") Long id){
        return this.petService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePetById(@PathVariable("id") Long id){
        boolean ok = this.petService.deleteById(id);
        if(ok){
            return "Pet with id " + id + " is deleted";
        }else{
            return "ERROR deleting a pet with id " + id;
        }
    }

}
