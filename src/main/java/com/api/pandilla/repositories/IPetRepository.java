package com.api.pandilla.repositories;

import com.api.pandilla.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<PetModel, Long> {


}
