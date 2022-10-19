package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
