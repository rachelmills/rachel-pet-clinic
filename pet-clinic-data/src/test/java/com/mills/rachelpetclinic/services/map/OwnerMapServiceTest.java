package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rachelmills on 27/8/19.
 */
public class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long ownerId = 1L;

    @BeforeEach
    public void setUp() throws Exception {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName("Mills").build());
    }

    @Test
    public void findAll() throws Exception {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    public void findById() throws Exception {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    public void save() throws Exception {
        Owner owner2 = Owner.builder().id(2L).firstName("Rachel").build();
        Owner savedOwner2 = ownerMapService.save(owner2);
        assertEquals(new Long(2), savedOwner2.getId());
    }

    @Test
    public void delete() throws Exception {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    public void findByLastName() throws Exception {
        Owner owner = ownerMapService.findByLastName("Mills");
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    public void findByLastNameNotFound() throws Exception {
        Owner owner = ownerMapService.findByLastName("Rachel");
        assertNull(owner);
    }

}