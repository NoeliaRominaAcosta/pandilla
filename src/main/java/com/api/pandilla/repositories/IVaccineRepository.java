package com.api.pandilla.repositories;

import com.api.pandilla.models.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepository extends JpaRepository<Vaccine, Long> {

}
