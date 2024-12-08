package com.example.spring_project.controllers;

import com.example.spring_project.entities.Household;
import com.example.spring_project.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class HouseholdController {
    private HouseholdService householdService;
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;

    }
    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        return new ResponseEntity<>(householdService.createHousehold(household), HttpStatus.CREATED);
    }
    @PutMapping("/{eircode}")
    public ResponseEntity<Household> updateHousehold(@PathVariable String eircode, @Valid @RequestBody Household household) {
        return new ResponseEntity<>(householdService.updateHousehold(eircode, household), HttpStatus.OK);
    }
    @GetMapping("/{eircode}")
    public ResponseEntity<Object> getHouseholdByEircode(@PathVariable String eircode) {
        return householdService.findByEircode(eircode)
                .map(household -> new ResponseEntity<>(household, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHousehold(eircode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
