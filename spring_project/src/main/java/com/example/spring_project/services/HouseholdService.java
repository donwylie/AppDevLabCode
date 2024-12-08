package com.example.spring_project.services;

import com.example.spring_project.entities.Household;
import com.example.spring_project.entities.Pet;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface HouseholdService {
    static List<Pet> getAllHouseholds() {
        return null;
    }

    List<Household> findAll();

    Household findById(Long id);

    int count();

    <HouseholdInput> Household create(HouseholdInput input);

    boolean deleteById(Long id);

    Household createHousehold(@Valid Household household);

    Household updateHousehold(String eircode, @Valid Household household);

    Optional<Object> findByEircode(String eircode);

    void deleteHousehold(String eircode);
}
