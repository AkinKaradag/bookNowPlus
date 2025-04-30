package booknowplus.domain.model;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private final Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CreateStatus status;


}
