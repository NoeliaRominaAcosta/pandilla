package com.api.pandilla.repositories;

import com.api.pandilla.models.Adoption.AdoptionApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdoptionApplicationRepository extends JpaRepository<AdoptionApplication, Long> {
    Optional<AdoptionApplication> findByPetId(Long petId);
}