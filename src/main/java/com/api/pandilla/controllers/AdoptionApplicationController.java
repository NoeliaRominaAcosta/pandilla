package com.api.pandilla.controllers;

import com.api.pandilla.models.Adoption.AdoptionApplication;
import com.api.pandilla.models.Family;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.services.AdoptionApplicationService;
import com.api.pandilla.services.FamilyService;
import com.api.pandilla.services.PetService;
import dto.AdoptionApplicationDTO;
import dto.FamilyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.ApplicationStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/adoptions")
@RequiredArgsConstructor
public class AdoptionApplicationController {

    private final AdoptionApplicationService adoptionApplicationService;
    private final PetService petService;
    private final FamilyService familyService;

    @PostMapping
    public ResponseEntity<AdoptionApplication> createApplication(@RequestBody AdoptionApplicationDTO applicationDTO) {
        // Crear una nueva instancia de AdoptionApplication
        AdoptionApplication application = new AdoptionApplication();
        // Obtener la familia
        Family family = familyService.getFamilyById(applicationDTO.getFamily().getId())
                .orElseThrow(() -> new IllegalArgumentException("Family not found"));
        application.setFamily(family);
        // Asignar los campos desde el DTO
        application.setAdopterEmail(applicationDTO.getAdopterEmail());
        application.setAdopterNotes(applicationDTO.getAdopterNotes());
        application.setApplicationDate(LocalDate.now()); // Establecer la fecha actual como la de solicitud
        application.setStatus(ApplicationStatus.PENDING); // Establecer el estado inicial como PENDING

        // Establecer la mascota relacionada (puedes obtenerla del servicio o repositorio)
        PetModel pet = petService.getById(applicationDTO.getPet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));
        if (pet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Manejar el caso en el que la mascota no exista
        }
        application.setPet(pet);

        // Guardar la solicitud de adopción usando el servicio
        AdoptionApplication createdApplication = adoptionApplicationService.createApplication(application);

        // Retornar la respuesta
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApplication);
    }


    @GetMapping
    public ResponseEntity<List<AdoptionApplication>> getAllApplications() {
        List<AdoptionApplication> applications = adoptionApplicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdoptionApplication> getApplicationById(@PathVariable Long id) {
        AdoptionApplication application = adoptionApplicationService.getApplicationById(id)
                .orElseThrow(() -> new IllegalArgumentException("Adoption application not found with id: " + id));
        return ResponseEntity.ok(application);
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<AdoptionApplication> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");
        AdoptionApplication updatedApplication = adoptionApplicationService.updateStatus(id, newStatus);
        return ResponseEntity.ok(updatedApplication);
    }
    @GetMapping("/pets/{petId}/status")
    public ResponseEntity<ApplicationStatus> getStatusByPetId(@PathVariable Long petId) {
        var application = adoptionApplicationService.findByPetId(petId);
        if (application.isPresent()) {
            return ResponseEntity.ok(application.get().getStatus());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}