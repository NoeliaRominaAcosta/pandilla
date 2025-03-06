package com.api.pandilla.controllers;

import com.api.pandilla.models.PetModel;
import com.api.pandilla.services.PetService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@OpenAPIDefinition(info = @Info(title = "API del refugio Pandilla Animal", version = "1.0", description = "Documentación de la API"))
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;
    @GetMapping
    public ArrayList<PetModel> getPets(){
        return this.petService.getPets();
    }

    @PostMapping
    public PetModel savePet(@RequestParam("name") String name,
                            @RequestParam("age") int age,
                            @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrivalDate,
                            @RequestParam("adoptedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date adoptedDate,
                            @RequestParam("vetVisitDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date vetVisitDate,
                            @RequestParam("birthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
                            @RequestParam("healthCondition") String healthCondition,
                            @RequestParam(value = "dewormed", required = false) Boolean dewormed,
                            @RequestParam(value = "castrated", required = false) Boolean castrated,
                            @RequestParam("image") MultipartFile image) throws IOException, ParseException {

        // Convertir la imagen a Base64
        String encodedImage = encodeImage(image.getBytes());

        // Crear el objeto PetModel
        PetModel pet = new PetModel();
        pet.setName(name);
        pet.setAge(age);
        pet.setArrivalDate(arrivalDate);
        pet.setAdoptedDate(adoptedDate);
        pet.setVetVisitDate(vetVisitDate);
        pet.setBirthDate(birthDate);
        pet.setHealthCondition(healthCondition);
        pet.setDewormed(dewormed);
        pet.setCastration(castrated);
        pet.setImage(encodedImage); // Guardar la imagen codificada

        // Llamar al servicio para guardar la mascota
        return petService.savePet(pet);
    }

    // Método para codificar la imagen en Base64
    public String encodeImage(byte[] imageBytes) {
        return Base64.encodeBase64String(imageBytes);
    }


    @GetMapping(path = "/{id}")
    public Optional<PetModel> getPetById(@PathVariable Long id){
        return this.petService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public PetModel updatePet(@RequestBody PetModel request, @PathVariable("id") Long id){
        return this.petService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePetById(@PathVariable("id") Long id){
        boolean ok = this.petService.deleteById(id);
        if(ok){
            return "Pet with id " + id + " is deleted";
        }else{
            return "ERROR deleting a pet with id " + id;
        }
    }

}
