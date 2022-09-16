package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.model.Owner;
import guru.springframework.model.Vet;
import guru.springframework.services.OwnerService;
import guru.springframework.services.PetService;
import guru.springframework.services.VetService;
import guru.springframework.services.map.OwnerServiceMap;
import guru.springframework.services.map.PetServiceMap;
import guru.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
      ownerService= new OwnerServiceMap();
      vetService= new VetServiceMap();

    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Rodricks");
        owner.setLastName("PremKumar");
        ownerService.save(owner);
        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("Rodricks");
        owner.setLastName("Kumar");
        ownerService.save(owner);
        System.out.println("loaded owners");
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("sam");
        vetService.save(vet);
        System.out.println("loaded vets");

    }
}
