package com.api.pandilla.controllers;

import com.api.pandilla.models.Families;
import com.api.pandilla.services.FamiliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/families")
public class FamiliesController {
    @Autowired
    FamiliesService service;

    @GetMapping
    public ArrayList<Families> getFamilies(){
        return this.service.getAllFams();
    }
    @PostMapping
    public Families saveFamilies(@RequestBody Families family){
        return this.service.savefamily(family);
    }
    @GetMapping("/{id}")
    public Optional<Families> getFamsById(@PathVariable long id){
        return this.service.getFamById(id);
    }
    @PutMapping("/{id}")
    public Families updateFamilies(@RequestBody Families request, @PathVariable("id") Long id){
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
