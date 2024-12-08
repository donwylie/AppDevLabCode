package com.example.spring_project.controllers;

import com.example.spring_project.entities.Household;
import com.example.spring_project.entities.Pet;
import com.example.spring_project.services.HouseholdService;
import com.example.spring_project.services.PetService;
import lombok.AllArgsConstructor;
import org.dataloader.stats.Statistics;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PetGraph {
    private final HouseholdService householdService;
    private final PetService petService;

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.findAll();
    }

    @QueryMapping
    public List<Pet> getAllPetsByAnimalType(@Argument String animalType) {
        return petService.findByAnimalType(animalType);
    }

    @QueryMapping
    public Household getHousehold(@Argument Long id) {
        return householdService.findById(id);
    }

    @QueryMapping
    public Pet getPet(@Argument Long id) {
        return petService.findById(id);
    }

    @QueryMapping
    public Statistics getStatistics() {
        int totalHouseholds = householdService.count();
        int totalPets = petService.count();
        return new Statistics();
    }

    @MutationMapping
    public <HouseholdInput> Household createHousehold(@Argument HouseholdInput input) {
        return householdService.create(input);
    }

    public boolean deleteHouseholdById(@Argument Long id) {
        return householdService.deleteById(id);
    }

    @MutationMapping
    public boolean deletePetById(@Argument Long id) {
        return petService.deleteById(id);
    }
}
