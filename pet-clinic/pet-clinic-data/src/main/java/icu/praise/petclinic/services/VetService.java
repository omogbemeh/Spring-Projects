package icu.praise.petclinic.services;

import icu.praise.petclinic.model.Vet;

import java.util.List;

public interface VetService {
    List<Vet> findAll();
    Vet save(Vet vet);
    Vet findById(Long id);

}
