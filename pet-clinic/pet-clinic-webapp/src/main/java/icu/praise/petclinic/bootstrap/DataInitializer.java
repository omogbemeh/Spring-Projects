package icu.praise.petclinic.bootstrap;

import icu.praise.petclinic.model.Owner;
import icu.praise.petclinic.model.Pet;
import icu.praise.petclinic.services.map.OwnerMapService;
import icu.praise.petclinic.services.map.PetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerMapService ownerMapService;
    private final PetMapService petMapService;
    public DataInitializer(OwnerMapService ownerMapService, PetMapService petMapService) {
        this.ownerMapService = ownerMapService;
        this.petMapService = petMapService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running the Bootstrap Class");



        Pet pet1 = new Pet();
        pet1.setId(5L);
        pet1.setName("John");
        petMapService.save(pet1.getId(), pet1);

        Pet pet2 = new Pet();
        pet2.setId(6L);
        pet2.setName("Doe");
        petMapService.save(pet2.getId(), pet2);

        Pet pet3 = new Pet();
        pet3.setId(7L);
        pet3.setName("Jane");
        petMapService.save(pet3.getId(), pet3);

        Pet pet4 = new Pet();
        pet4.setId(8L);
        pet4.setName("Jane");
        petMapService.save(pet4.getId(), pet4);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Praise");
        ownerMapService.save(owner1.getId(), owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Faith");
        ownerMapService.save(owner2.getId(), owner2);

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Divine");
        ownerMapService.save(owner3.getId(), owner3);

        Owner owner4 = new Owner();
        owner4.setId(4L);
        owner4.setFirstName("Christian");
        ownerMapService.save(owner4.getId(), owner4);

        System.out.println("Saved the following Owners and Pets...");
        System.out.println(ownerMapService.count());
        System.out.println(petMapService.count());
        System.out.println(ownerMapService.findById(4L).getFirstName());

//        Object[] objects = petMapService.findAll().toArray();
//        System.out.println(objects[0]);
    }
}
