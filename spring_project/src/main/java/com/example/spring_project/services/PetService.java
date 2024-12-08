package com.example.spring_project.services;

import com.example.spring_project.entities.Pet;
import jakarta.validation.Valid;

import java.util.List;

public interface PetService {
    Pet getByID (int ID) throws NotFoundException;
    List<Pet> getAllPets ();

    static void deletePet(int ID) throws NotFoundException {

    }

    List<Pet> findByAnimalType(String animalType);

    Pet findById(Long id);

    int count();

    boolean deleteById(Long id);

    Pet savePet(@Valid Pet pet);

    Pet updatePet(Long id, @Valid Pet pet);

    Pet getPetById(Long id);
}
