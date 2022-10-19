package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pettypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetType  extends BaseEntity{
    @Column(name="name")
    private String name;

}
