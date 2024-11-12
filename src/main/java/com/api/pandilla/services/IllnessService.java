package com.api.pandilla.services;

import com.api.pandilla.models.Illness;
import com.api.pandilla.repositories.IllnessRepository;
import dto.IllnessDTO;
import mappers.IllnessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IllnessService {

    @Autowired
    IllnessRepository repository;

    @Autowired
    IllnessMapper illnessMapper;

    // Obtener lista de IllnessDTO
    public List<IllnessDTO> getAllIllness() {
        List<Illness> illnesses = (List<Illness>) repository.findAll();
        return illnesses.stream()
                .map(illnessMapper::illnessToIllnessDTO)
                .collect(Collectors.toList());
    }

    // Guardar IllnessDTO
    public IllnessDTO saveIllness(IllnessDTO illnessDTO) {
        Illness illness = illnessMapper.illnessDTOToIllness(illnessDTO);
        Illness savedIllness = repository.save(illness);
        return illnessMapper.illnessToIllnessDTO(savedIllness);
    }

    // Obtener IllnessDTO por ID
    public IllnessDTO getIllnessById(Long id) {
        Illness illness = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Illness with ID " + id + " not found"));
        return illnessMapper.illnessToIllnessDTO(illness);
    }

    // Actualizar IllnessDTO
    public IllnessDTO updateById(IllnessDTO request, Long id) {
        Illness illness = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Illness with ID " + id + " not found"));

        // Actualizar los campos
        illness.setName(request.getName());
        illness.setDescription(request.getDescription());
        illness.setTreatment(request.getTreatment());
        illness.setDiagnosingDate(request.getDiagnosingDate());

        Illness updatedIllness = repository.save(illness);
        return illnessMapper.illnessToIllnessDTO(updatedIllness);
    }

    // Eliminar IllnessDTO por ID
    public Boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
