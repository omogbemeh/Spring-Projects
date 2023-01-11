package icu.praise.petclinic.services;

import icu.praise.petclinic.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> findByName(String name);
    Pet findById(Long id);
    List <Pet> findAll();
    Pet save(Pet pet);
}
