package com.api.pandilla.controllers;

import com.api.pandilla.models.Family;
import com.api.pandilla.services.FamilyService;
import dto.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    FamilyService service;

    @GetMapping
    public List<FamilyDTO> getFamilies() {
        return service.getAllFams();
    }

    @PostMapping
    public FamilyDTO saveFamilies(@RequestBody FamilyDTO familyDTO) {
        return service.saveFamily(familyDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDTO> getFamsById(@PathVariable long id) {
        Optional<FamilyDTO> familyDTO = service.getFamById(id);
        return familyDTO.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamilyDTO> updateFamilies(@RequestBody FamilyDTO request, @PathVariable("id") Long id) {
        return ResponseEntity.ok(service.updateFamily(request, id));
    }

    @DeleteMapping("/{id}")
    public String deleteFamilyById(@PathVariable("id") Long id) {
        boolean ok = service.deleteFamById(id);
        if (ok) {
            return "Family with id " + id + " is deleted";
        } else {
            return "ERROR deleting a family with id " + id;
        }
    }
}
