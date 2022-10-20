package guru.springframework.sfgpetclinic.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    @Mock
    OwnerRepository ownerRepository;
    final String LASTNAME="Smith";
    final Long ID= 1L;
    Owner returnedOwner;
    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(ID).lastName(LASTNAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet  = new HashSet<>();
        ownerSet.add(Owner.builder().id(ID).lastName(LASTNAME).build());

        ownerSet.add(Owner.builder().id(2L).lastName(LASTNAME).build());
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> returnedSet = ownerSDJpaService.findAll();
        assertNotNull(returnedSet);
        assertEquals(2,returnedSet.size());
           }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        assertNotNull(ownerSDJpaService.findById(ID));
        assertEquals(1L,ownerSDJpaService.findById(1L).getId());

    }
    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(ownerSDJpaService.findById(ID));

    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner newOwner = Owner.builder().id(ID).lastName(LASTNAME).build();
        Owner savedOwner = ownerSDJpaService.save(newOwner);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {

     ownerSDJpaService.delete(returnedOwner);
     verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(returnedOwner.getId());
        assertEquals(0,ownerSDJpaService.findAll().size());
        verify(ownerRepository,times(1)).deleteById(any());
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(ID).lastName(LASTNAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner owner1 = ownerSDJpaService.findByLastName(LASTNAME);
        assertEquals(LASTNAME,owner1.getLastName());
        verify(ownerRepository,times(1)).findByLastName(any());


    }
}