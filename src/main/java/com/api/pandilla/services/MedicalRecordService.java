package com.api.pandilla.services;

import com.api.pandilla.models.MedicalRecord;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.repositories.IMedicalRecordRepository;
import com.api.pandilla.repositories.IPetRepository;
import dto.MedicalRecordDTO;
import lombok.RequiredArgsConstructor;
import mappers.MedicalRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final IMedicalRecordRepository medicalRecordRepository;
    private final IPetRepository petRepository; // Inyectamos el repositorio de Pet
    private final MedicalRecordMapper medicalRecordMapper;
    private final PetService petService;
    public List<MedicalRecordDTO> getRecordsByPetId(Long petId) {
        return medicalRecordRepository.findByPetId(petId).stream()
                .map(medicalRecordMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MedicalRecordDTO createRecord(MedicalRecordDTO medicalRecordDTO) {
        // Obtener la mascota desde el ID que viene en el DTO
        PetModel pet = petRepository.findById(medicalRecordDTO.getPetId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));

        // Convertir el DTO a entidad y asignar el Pet
        MedicalRecord medicalRecord = medicalRecordMapper.toEntity(medicalRecordDTO);

        medicalRecord.setPet(pet);

        // Guardar el registro médico
        medicalRecord = medicalRecordRepository.save(medicalRecord);
        pet.setMedicalRecordId(medicalRecord.getId());
        petService.updateById(pet,pet.getId());
        return medicalRecordMapper.toDTO(medicalRecord);
    }
}