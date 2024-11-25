package com.api.pandilla.repositories;

import com.api.pandilla.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByFamilyId(Long familyId);  // Buscar donaciones por familia adoptante
}