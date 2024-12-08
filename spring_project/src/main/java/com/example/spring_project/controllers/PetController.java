package com.example.spring_project.controllers;
import com.example.spring_project.entities.Pet;
import com.example.spring_project.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class PetController {
    @Autowired
    private PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        return new ResponseEntity<>(petService.savePet(pet), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @Valid @RequestBody Pet pet) {
        return new ResponseEntity<>(petService.updatePet(id, pet), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return new ResponseEntity<>(petService.getPetById(id), HttpStatus.OK);
    }

}
