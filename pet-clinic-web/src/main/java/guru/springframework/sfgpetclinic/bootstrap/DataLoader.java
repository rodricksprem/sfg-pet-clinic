package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);


        Owner owner = new Owner();
        owner.setFirstName("Rodricks");
        owner.setLastName("PremKumar");

        ownerService.save(owner);
        owner = new Owner();
        owner.setFirstName("Rodricks");
        owner.setLastName("Kumar");
        ownerService.save(owner);
        System.out.println("loaded owners");
        Vet vet = new Vet();

        vet.setFirstName("sam");
        vet.setLastName("Axe");
        vetService.save(vet);
        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
        System.out.println("loaded vets");


    }
}
