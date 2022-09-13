package guru.springframework.model.services;

import guru.springframework.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String name);

}
