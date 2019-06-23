package com.mills.rachelpetclinic.services;

import com.mills.rachelpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
