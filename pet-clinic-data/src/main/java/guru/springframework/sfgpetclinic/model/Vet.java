package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vet extends  Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name="vet_sepcialties",joinColumns = @JoinColumn(name="vet_id"),
    inverseJoinColumns = @JoinColumn(name="specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

}
