package com.example.spring_project.resolver;

import com.example.spring_project.daos.PetRepository;
import com.example.spring_project.entities.Pet;
import com.example.spring_project.services.HouseholdService;
import com.example.spring_project.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PetResolver {
    private final PetRepository petRepository;

    private final PetService petService;
    private final HouseholdService householdService;

    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }
    public Pet getPetById(Long id) {
        return petService.getPetById(id);
    }
    public Pet createPet(Pet pet) {
        return pet;
    }
    public Pet updatePet(Pet pet) {
        return pet;
    }
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
