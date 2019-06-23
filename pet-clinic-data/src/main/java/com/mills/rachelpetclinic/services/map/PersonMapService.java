package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Person;
import com.mills.rachelpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public class PersonMapService extends AbstractMapService<Person, Long> implements CrudService<Person, Long>{
    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Person save(Person Person) {
        return super.save(Person.getId(), Person);
    }

    @Override
    public void delete(Person Person) {
        super.delete(Person);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
