package com.example.spring_project.daos;

import com.example.spring_project.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByName(String name); // Correct property name
}