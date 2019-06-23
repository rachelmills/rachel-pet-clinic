package com.mills.rachelpetclinic.services;

import com.mills.rachelpetclinic.model.Owner;

/**
 * Created by rachelmills on 23/6/19.
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
