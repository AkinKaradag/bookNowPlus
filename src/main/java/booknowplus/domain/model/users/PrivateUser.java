package booknowplus.domain.model.users;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class PrivateUser extends User {
    private String firstName;
    private String lastName;

    private String validateRequired(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        return value;
    }

    public PrivateUser(Long id, String email, String passwordHash, String firstName, String lastName) {
        super(id, email, passwordHash);
        this.firstName = validateRequired(firstName, "firstName");
        this.lastName = validateRequired(lastName, "lastName");
        this.status = CreateStatus.PENDING;

    }

    public static PrivateUser create(Long id, String email, String passwordHash, String firstName, String lastName, String phone) {
        PrivateUser user = new PrivateUser(id, email, passwordHash, firstName, lastName);
        user.changePhone(phone);
        return user;
    }

    public void changeFirstName(String firstName) {
        this.firstName = validateRequired(firstName, "firstName");
    }

    public void changeLastName(String lastName) {
        this.lastName = validateRequired(lastName, "lastName");
    }

}
