package com.mills.rachelpetclinic.repositories;

import com.mills.rachelpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rachelmills on 7/7/19.
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
