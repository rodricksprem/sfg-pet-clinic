package guru.springframework.model.services;

import guru.springframework.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByName(String name);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
