package com.mills.rachelpetclinic.model;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public class Vet extends Person {

    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
