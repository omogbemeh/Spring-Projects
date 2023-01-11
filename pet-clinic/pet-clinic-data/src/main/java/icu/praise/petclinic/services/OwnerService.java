package icu.praise.petclinic.services;

import icu.praise.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Set<Owner> findAll();
    Owner findById(Long Id);
    Owner findByLastName (String lastname);
    Owner save(Owner owner);

}
