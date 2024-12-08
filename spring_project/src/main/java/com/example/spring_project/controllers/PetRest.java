package com.example.spring_project.controllers;

import com.example.spring_project.entities.Pet;
import com.example.spring_project.services.NotFoundException;
import com.example.spring_project.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PetRest {
    PetService petService;
    @GetMapping("/pets")
    List<Pet> getPets() {
        return petService.getAllPets();
    }
    @GetMapping("/pets/{ID}")
    Pet getPet(@PathVariable int ID) throws NotFoundException {
        return petService.getByID(ID);
    }
    @DeleteMapping("/pets/{ID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletetPet(@PathVariable int ID) throws NotFoundException {
        PetService.deletePet(ID);
    }
}
