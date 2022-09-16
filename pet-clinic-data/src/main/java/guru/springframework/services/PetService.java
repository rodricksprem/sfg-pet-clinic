package guru.springframework.services;

import guru.springframework.model.Pet;
import guru.springframework.services.CrudService;

import java.util.Set;

public interface PetService extends CrudService<Pet,Long> {

}
