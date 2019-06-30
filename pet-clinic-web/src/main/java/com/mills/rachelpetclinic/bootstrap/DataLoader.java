package com.mills.rachelpetclinic.bootstrap;

import com.mills.rachelpetclinic.model.Owner;
import com.mills.rachelpetclinic.model.Pet;
import com.mills.rachelpetclinic.model.PetType;
import com.mills.rachelpetclinic.model.Vet;
import com.mills.rachelpetclinic.services.OwnerService;
import com.mills.rachelpetclinic.services.PetTypeService;
import com.mills.rachelpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by rachelmills on 26/6/19.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rachel");
        owner1.setLastName("Mills");
        owner1.setAddress("139/555 Princes Highway");
        owner1.setCity("Rockdale");
        owner1.setTelephone("0430581441");

        Pet rachelsPet = new Pet();
        rachelsPet.setPetType(savedCatPetType);
        rachelsPet.setOwner(owner1);
        rachelsPet.setBirthDate(LocalDate.of(2001, Month.NOVEMBER, 5));
        rachelsPet.setName("Prettiest Puss");
        owner1.getPets().add(rachelsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Edward");
        owner2.setLastName("Sonzay");
        owner2.setAddress("139/555 Princes Highway");
        owner2.setCity("Rockdale");
        owner2.setTelephone("0467501606");

        Pet edsPet = new Pet();
        edsPet.setPetType(savedCatPetType);
        edsPet.setOwner(owner2);
        edsPet.setBirthDate(LocalDate.of(2001, Month.NOVEMBER, 5));
        edsPet.setName("Best Puss");
        owner2.getPets().add(edsPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners ....");
        Vet vet1 = new Vet();
        vet1.setFirstName("Susan");
        vet1.setLastName("Long");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Andy");
        vet2.setLastName("Short");
        vetService.save(vet2);

        System.out.println("Loaded vets ....");
    }
}
