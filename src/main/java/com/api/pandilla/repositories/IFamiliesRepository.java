package com.api.pandilla.repositories;

import com.api.pandilla.models.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamiliesRepository extends JpaRepository<Families, Long> {
}
