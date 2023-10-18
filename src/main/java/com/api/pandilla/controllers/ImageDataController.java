package com.api.pandilla.controllers;

import com.api.pandilla.models.ImageData;
import com.api.pandilla.models.PetModel;
import com.api.pandilla.services.ImageDataService;
import com.api.pandilla.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;
    @Autowired
    private PetService petService;
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("id") Long id) throws IOException {
        Optional<PetModel> optionalPetModel = petService.getById(id);

        if (optionalPetModel.isPresent()) {
            PetModel petModel = optionalPetModel.get();
            ImageUploadResponse response = imageDataService.uploadImage(file, petModel);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("PetModel not found for ID: " + id);
        }
    }


    @GetMapping("/info/{name}")
    public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
        ImageData image = imageDataService.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getImageById(@PathVariable("id") Long id){
        byte[] image = imageDataService.getImage(id);
        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);

    }


}
