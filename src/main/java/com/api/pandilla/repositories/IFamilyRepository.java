package com.api.pandilla.repositories;

import com.api.pandilla.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamilyRepository extends JpaRepository<Family, Long> {
}
