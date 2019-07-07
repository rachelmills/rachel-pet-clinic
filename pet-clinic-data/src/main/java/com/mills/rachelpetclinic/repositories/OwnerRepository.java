package com.mills.rachelpetclinic.repositories;

import com.mills.rachelpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rachelmills on 7/7/19.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
