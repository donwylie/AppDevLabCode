package com.example.spring_project.services;

import com.example.spring_project.entities.Pet;
import com.example.spring_project.daos.PetRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImplementation implements PetService {

    PetRepository petRepository;

    @Override
    public Pet getByID(int ID) throws NotFoundException {
        Optional<Pet> optionalPets = petRepository.findById((long) ID);
        if (optionalPets.isPresent()) {
            return optionalPets.get();
        }
        throw new NotFoundException("Pet Not Found");
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public void deletePet(int ID) throws NotFoundException {
        Optional<Pet> optionalPets = petRepository.findById((long) ID);
        if (optionalPets.isPresent())
            petRepository.deleteById((long) ID);
        else throw new NotFoundException("Pet Not Found");
    }

    @Override
    public List<Pet> findByAnimalType(String animalType) {
        List<Pet> pets = List.of();
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Pet savePet(Pet pet) {
        return null;
    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        return null;
    }

    @Override
    public Pet getPetById(Long id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) throws NotFoundException {
        PetService.deletePet(Math.toIntExact(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
