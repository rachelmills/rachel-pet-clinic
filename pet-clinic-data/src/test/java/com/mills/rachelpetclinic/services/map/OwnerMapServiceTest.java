package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by rachelmills on 27/8/19.
 */
public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    public void setUp() throws Exception {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    public void findAll() throws Exception {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void findByLastName() throws Exception {

    }

}