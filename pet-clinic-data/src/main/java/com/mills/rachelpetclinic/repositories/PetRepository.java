package com.mills.rachelpetclinic.repositories;

import com.mills.rachelpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rachelmills on 7/7/19.
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
