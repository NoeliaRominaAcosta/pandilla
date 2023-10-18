package com.api.pandilla.repositories;

import com.api.pandilla.models.ImageData;
import com.api.pandilla.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {


    Optional<ImageData> findByName(String name);
}