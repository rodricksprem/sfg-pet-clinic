package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long id = 1L;
    final String lastName="rods";
    @BeforeEach
    void setUp() {
     ownerServiceMap=new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
     ownerServiceMap.save(Owner.builder().id(1L).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = Owner.builder().id(2L).build();
        Owner saveOwner=ownerServiceMap.save(owner2);
        assertEquals(2,saveOwner.getId());
    }
    @Test
    void saveNoId() {
        Owner owner2 = Owner.builder().build();
        Owner saveOwner=ownerServiceMap.save(owner2);
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }
    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1L));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(id);
        assertEquals(1,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertEquals(lastName,owner.getLastName());
    }

    @Test
    void findByLastNameNull() {
        Owner owner = ownerServiceMap.findByLastName("test");
        assertNull(owner);
    }
}