package com.mills.rachelpetclinic.services;

import com.mills.rachelpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

    Owner findByLastName(String lastName);
}
