package com.api.pandilla.controllers;

import com.api.pandilla.models.Illness;
import com.api.pandilla.services.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
   private IllnessService illnessService;

    @GetMapping
    public ArrayList<Illness> getIllnessList(){
        return this.illnessService.getAllIllness();
    }
    @PostMapping
    public Illness saveIlness(@RequestBody Illness illness){
        return this.illnessService.saveIllness(illness);
    }
    @GetMapping("/{id}")
    public Optional<Illness> getIllnessById(@PathVariable Long id){
        return this.illnessService.getIllnessById(id);
    }
    @PutMapping(path = "/{id}")
    public Illness updateIllness(@RequestBody Illness request, @PathVariable("id") Long id){
        return this.illnessService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteIllnessById(@PathVariable("id") Long id) {
        boolean ok = this.illnessService.deleteById(id);
        if (ok) {
            return "Illness with id " + id + " is deleted";
        } else {
            return "ERROR deleting a illness with id " + id;
        }
    }
}
