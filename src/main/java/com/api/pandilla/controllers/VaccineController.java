package com.api.pandilla.controllers;

import com.api.pandilla.models.PetModel;
import com.api.pandilla.models.Vaccine;
import com.api.pandilla.services.PetService;
import com.api.pandilla.services.VaccineService;
import dto.VaccineDTO;
import mappers.VaccineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/vaccine")public class VaccineController {

    @Autowired
    VaccineService service;
    @Autowired
    PetService petService;

    @GetMapping
    public ArrayList<VaccineDTO> getVaccines() {
        // Convertimos la lista de entidades a DTOs
        return this.service.getVaccines().stream()
                .map(VaccineMapper.INSTANCE::toVaccineDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @GetMapping("/getPet/{petId}")
    public Set<VaccineDTO> getVaccinesByPet(@PathVariable Long petId) {
        return this.petService.getById(petId)
                .map(PetModel::getVaccines)
                .orElse(Collections.emptySet())
                .stream()
                .map(VaccineMapper.INSTANCE::toVaccineDTO)
                .collect(Collectors.toSet());
    }

    @PostMapping
    public VaccineDTO saveVaccine(@RequestBody VaccineDTO vaccineDTO) {
        // Convertimos el DTO a entidad, lo guardamos y convertimos el resultado a DTO
        Vaccine vaccine = VaccineMapper.INSTANCE.toVaccine(vaccineDTO);
        Vaccine savedVaccine = this.service.saveVaccine(vaccine);
        return VaccineMapper.INSTANCE.toVaccineDTO(savedVaccine);
    }

    @GetMapping(path = "/{id}")
    public Optional<VaccineDTO> getVaccineById(@PathVariable Long id) {
        return this.service.getVaccineById(id)
                .map(VaccineMapper.INSTANCE::toVaccineDTO);
    }

    @PutMapping(path = "/{id}")
    public VaccineDTO updateVaccine(@RequestBody VaccineDTO request, @PathVariable("id") Long id) {
        Vaccine vaccineRequest = VaccineMapper.INSTANCE.toVaccine(request);
        Vaccine updatedVaccine = this.service.updateById(vaccineRequest, id);
        return VaccineMapper.INSTANCE.toVaccineDTO(updatedVaccine);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteVaccineById(@PathVariable("id") Long id) {
        boolean ok = this.service.deleteById(id);
        if (ok) {
            return "Vaccine id " + id + " is deleted";
        } else {
            return "Vaccine id " + id + " is not found";
        }
    }
}