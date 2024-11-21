package com.api.pandilla.controllers;

import com.api.pandilla.services.MedicalRecordService;
import dto.MedicalRecordDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<MedicalRecordDTO>> getRecordsByPetId(@PathVariable Long petId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByPetId(petId));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDTO> createMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDTO) {
        var createdRecord = medicalRecordService.createRecord(medicalRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }
}