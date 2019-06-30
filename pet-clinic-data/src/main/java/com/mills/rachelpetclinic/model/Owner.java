package com.mills.rachelpetclinic.model;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
