package com.api.pandilla.controllers;

import com.api.pandilla.models.Illness;
import com.api.pandilla.services.IllnessService;
import dto.IllnessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    // Obtener lista de IllnessDTO
    @GetMapping
    public List<IllnessDTO> getIllnessList() {
        return this.illnessService.getAllIllness();
    }

    // Guardar IllnessDTO
    @PostMapping
    public IllnessDTO saveIllness(@RequestBody IllnessDTO illnessDTO) {
        return this.illnessService.saveIllness(illnessDTO);
    }

    // Obtener IllnessDTO por ID
    @GetMapping("/{id}")
    public IllnessDTO getIllnessById(@PathVariable Long id) {
        return this.illnessService.getIllnessById(id);
    }

    // Actualizar IllnessDTO
    @PutMapping(path = "/{id}")
    public IllnessDTO updateIllness(@RequestBody IllnessDTO request, @PathVariable("id") Long id) {
        return this.illnessService.updateById(request, id);
    }

    // Eliminar IllnessDTO por ID
    @DeleteMapping("/{id}")
    public String deleteIllnessById(@PathVariable("id") Long id) {
        boolean ok = this.illnessService.deleteById(id);
        if (ok) {
            return "Illness with id " + id + " is deleted";
        } else {
            return "ERROR deleting illness with id " + id;
        }
    }
}
