package booknowplus.domain.model;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class User {

    private final Long id;
    private String email;
    private String password;
    private String phone;
    private CreateStatus status;


}
