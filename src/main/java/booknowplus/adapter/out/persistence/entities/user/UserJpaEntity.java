package booknowplus.adapter.out.persistence.entities.user;

import booknowplus.domain.model.enm.CreateStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "users")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String passwordHash;
    private String phone;

    @Enumerated(EnumType.STRING)
    private CreateStatus status;
}
