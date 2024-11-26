package com.api.pandilla.services;

import com.api.pandilla.models.Adoption.AdoptionApplication;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.repositories.AdoptionApplicationRepository;
import com.api.pandilla.repositories.IPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utils.ApplicationStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdoptionApplicationService {

    private final AdoptionApplicationRepository adoptionApplicationRepository;
    private final IPetRepository petRepository;

    public AdoptionApplication createApplication(AdoptionApplication application) {
        return adoptionApplicationRepository.save(application);
    }
    public List<AdoptionApplication> getAllApplications() {
        return adoptionApplicationRepository.findAll();
    }
    public Optional<AdoptionApplication> getApplicationById(Long id) {
        return adoptionApplicationRepository.findById(id);
    }
    public AdoptionApplication updateStatus(Long id, String newStatus) {
        AdoptionApplication application = adoptionApplicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Adoption application not found with id: " + id));

        // Validar el nuevo estado
        ApplicationStatus status;
        try {
            status = ApplicationStatus.valueOf(newStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value: " + newStatus);
        }

        application.setStatus(status);
        return adoptionApplicationRepository.save(application);
    }
    public Optional<AdoptionApplication> findByPetId(Long petId) {
        return adoptionApplicationRepository.findByPetId(petId);
    }


}
