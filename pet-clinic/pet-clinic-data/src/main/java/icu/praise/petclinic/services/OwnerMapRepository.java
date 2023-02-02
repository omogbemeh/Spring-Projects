package icu.praise.petclinic.services;

import icu.praise.petclinic.model.Owner;

public interface OwnerMapRepository extends MapRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
