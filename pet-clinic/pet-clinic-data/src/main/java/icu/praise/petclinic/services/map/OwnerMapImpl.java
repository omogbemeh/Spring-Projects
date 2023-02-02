package icu.praise.petclinic.services.map;

import icu.praise.petclinic.model.Owner;
import icu.praise.petclinic.services.OwnerMapRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OwnerMapImpl extends MapImpl<Owner, Long> implements OwnerMapRepository {

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner entry : super.findAll()) {
            if (entry.getLastName().equals(lastName)) {
                return entry;
            }
        }
        return null;
    }
}
