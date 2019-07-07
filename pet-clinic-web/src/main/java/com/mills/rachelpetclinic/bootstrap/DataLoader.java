package com.mills.rachelpetclinic.bootstrap;

import com.mills.rachelpetclinic.model.*;
import com.mills.rachelpetclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(rachelsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");
        visitService.save(catVisit);

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
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Andy");
        vet2.setLastName("Short");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded vets ....");
    }
}
