package com.api.pandilla.controllers;

import com.api.pandilla.models.Vaccine;
import com.api.pandilla.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    VaccineService service;

    @GetMapping
    public ArrayList<Vaccine> getVaccines() {
        return this.service.getVaccines();
    }

    @PostMapping
    public Vaccine saveVaccine(@RequestBody Vaccine vaccine) {
        return this.service.saveVaccine(vaccine);
    }

    @GetMapping(path = "/{id}")
    public Optional<Vaccine> getVaccineById(@PathVariable Long id) {
        return this.service.getVaccineById(id);
    }
    @PutMapping(path = "/{id}")
    public Vaccine updateVaccine(@RequestBody Vaccine request, @PathVariable("id") Long id){
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteVaccineById(@PathVariable("id") Long id){
        boolean ok = this.service.deleteById(id);
        if(ok){
            return "Vaccine id " + id + "is deleted";
        }else{
            return "Vaccine id " + id + "is not found";
        }
    }

}
