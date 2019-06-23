package com.mills.rachelpetclinic.services;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
