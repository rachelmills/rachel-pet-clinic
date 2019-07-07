package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Person;
import com.mills.rachelpetclinic.services.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
@Service
@Profile({"default", "map"})
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
    public Person save(Person person) {
        return super.save(person);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
