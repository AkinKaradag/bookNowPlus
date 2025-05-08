package booknowplus.domain.model.users;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PrivateUser extends User {
    private String firstName;
    private String lastName;
    private CreateStatus status;

    private String validateRequired(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        return value;
    }

    public PrivateUser(Long id, String email, String firstName, String lastName, CreateStatus status) {
        super(id, email);

        this.firstName = validateRequired(firstName, "firstName");
        this.lastName = validateRequired(lastName, "lastName");
        this.status = status;
    }

}
