package booknowplus.adapter.out.persistence.entities;

import booknowplus.domain.model.enm.CreateStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;

    @Enumerated(EnumType.STRING)
    private CreateStatus status;
}
