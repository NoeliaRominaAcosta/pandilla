package com.api.pandilla.repositories;

import com.api.pandilla.models.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<Illness,Long> {
}
