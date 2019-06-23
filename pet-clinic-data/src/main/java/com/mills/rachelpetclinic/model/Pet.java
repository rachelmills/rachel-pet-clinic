package com.mills.rachelpetclinic.model;

import java.time.LocalDate;

/**
 * Created by rachelmills on 23/6/19.
 */
public class Pet extends BaseEntity {

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {

        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
