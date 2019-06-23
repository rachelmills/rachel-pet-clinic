package com.mills.rachelpetclinic.services;

import com.mills.rachelpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
