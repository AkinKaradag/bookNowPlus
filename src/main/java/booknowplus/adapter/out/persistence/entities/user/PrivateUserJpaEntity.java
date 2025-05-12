package booknowplus.adapter.out.persistence.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "private_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PrivateUserJpaEntity extends UserJpaEntity{
    private String firstName;
    private String lastName;

}
