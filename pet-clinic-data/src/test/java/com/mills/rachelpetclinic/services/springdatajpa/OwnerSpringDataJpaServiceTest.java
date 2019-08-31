package com.mills.rachelpetclinic.services.springdatajpa;

import com.mills.rachelpetclinic.model.Owner;
import com.mills.rachelpetclinic.repositories.OwnerRepository;
import com.mills.rachelpetclinic.repositories.PetRepository;
import com.mills.rachelpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJpaServiceTest {

    @Mock OwnerRepository ownerRepository;
    @Mock PetRepository petRepository;
    @Mock PetTypeRepository petTypeRepository;

    @InjectMocks private OwnerSpringDataJpaService ownerService;

    public static final String LAST_NAME = "Mills";
    public static Owner returnedOwner;
    public static final long ID = 1L;


    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Owner owner2 = Owner.builder().id(2L).lastName("Sonzay").build();

        Set<Owner> ownersFound = new HashSet<>();
        ownersFound.add(returnedOwner);
        ownersFound.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownersFound);

        Set<Owner> owners = ownerService.findAll();

        assertEquals(ownersFound, owners);
        assertEquals(2, owners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(java.util.Optional.of(returnedOwner));
        Owner owner = ownerService.findById(ID);
        assertNotNull(owner);
        verify(ownerRepository).findById(ID);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.empty());
        Owner owner = ownerService.findById(ID);
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner savedOwner = ownerService.save(returnedOwner);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository, times(1)).delete(any(Owner.class));
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);

        Owner rachel = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, rachel.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}