package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    private final VisitService visitService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size()==0) {
            loadData();
        }


    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType=petTypeService.save(cat);
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType=petTypeService.save(dog);


        Owner owner = new Owner();
        owner.setFirstName("Rodricks");
        owner.setLastName("PremKumar");
        owner.setAddress("Chennai Thoraipakkam");
        owner.setCity("Chennai");
        owner.setTelephone("123456");
        Pet rodsPet = new Pet();
        rodsPet.setOwner(owner);
        rodsPet.setName("Just Cat");
        rodsPet.setPetType(saveCatPetType);
        rodsPet.setBirthDate(LocalDate.now());
        owner.getPets().add(rodsPet);
        ownerService.save(owner);
        owner = new Owner();
        owner.setFirstName("Flavio");
        owner.setLastName("Benito");

        owner.setAddress("Chennai Thoraipakkam");
        owner.setCity("Chennai");
        owner.setTelephone("123456");

        Pet flaviosPet = new Pet();
        flaviosPet.setOwner(owner);
        flaviosPet.setName("Rosco");
        flaviosPet.setPetType(saveDogPetType);
        flaviosPet.setBirthDate(LocalDate.now());
        owner.getPets().add(flaviosPet);
        ownerService.save(owner);
        System.out.println("loaded owners");
        Visit catVisit = new Visit();
        catVisit.setPet(rodsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneeze Kitty");
        visitService.save(catVisit);
        Visit dogVisit  = new Visit();
        dogVisit.setPet(flaviosPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneeze Kitty");
        visitService.save(dogVisit);
        Specialty specialty = new Specialty();
        specialty.setDescription("Radiology");
        Specialty savedRadiology= specialtiesService.save(specialty);
        specialty = new Specialty();
        specialty.setDescription("Surgery");
        Specialty savedSurgery= specialtiesService.save(specialty);

        Vet vet = new Vet();

        vet.setFirstName("sam");
        vet.setLastName("Axe");
        vet.getSpecialties().add(savedRadiology);
        vetService.save(vet);
        Vet vet2 = new Vet();

        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("loaded vets");

    }
}
