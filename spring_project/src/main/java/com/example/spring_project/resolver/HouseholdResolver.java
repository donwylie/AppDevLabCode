package com.example.spring_project.resolver;

import com.example.spring_project.daos.HouseholdRepository;
import com.example.spring_project.entities.Household;
import com.example.spring_project.services.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HouseholdResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final HouseholdRepository houseHoldRepository;

    public Household getHouseholdByEircode(String eircode) {
        return householdService.findByEircode(eircode)
                .orElseThrow(() -> new IllegalArgumentException("Household with Eircode " + eircode + " not found"));
    }

    public <Household> List<Household> getAllHouseholds() {
        HouseholdResolver householdService;
        return householdService.getAllHouseholds();
    }
    public Household createHousehold(String eircode) {
        Household household = Household.builder().eircode(eircode).build();
        HouseholdService householdService = null;
        return householdService.createHousehold(household);
    }


}
