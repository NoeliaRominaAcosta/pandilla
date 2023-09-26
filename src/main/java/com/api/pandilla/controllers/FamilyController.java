package com.api.pandilla.controllers;

import com.api.pandilla.models.Family;
import com.api.pandilla.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    FamilyService service;

    @GetMapping
    public ArrayList<Family> getFamilies(){
        return this.service.getAllFams();
    }
    @PostMapping
    public Family saveFamilies(@RequestBody Family family){
        return this.service.savefamily(family);
    }
    @GetMapping("/{id}")
    public Optional<Family> getFamsById(@PathVariable long id){
        return this.service.getFamById(id);
    }
    @PutMapping("/{id}")
    public Family updateFamilies(@RequestBody Family request, @PathVariable("id") Long id){
        return this.service.updateFamById(request,id);
    }
    @DeleteMapping("/{id}")
    public String deleteIllnessById(@PathVariable("id") Long id) {
        boolean ok = this.service.deleteFamById(id);
        if (ok) {
            return "Family with id " + id + " is deleted";
        } else {
            return "ERROR deleting a family with id " + id;
        }
    }
}
