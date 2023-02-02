package icu.praise.petclinic.services.map;

import icu.praise.petclinic.model.Pet;
import icu.praise.petclinic.services.PetMapRepository;
import org.springframework.stereotype.Service;

@Service
public class PetMapImpl extends MapImpl<Pet, Long> implements PetMapRepository {
}
