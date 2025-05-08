package booknowplus.domain.model.users;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode
@ToString
public abstract class User {

    private final Long id;
    private final String email;
    private String password;
    private String phone;
    private CreateStatus status;

    private String validateEmail(String email) {
        if (email == null || email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email;
    }

    private String validatePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid password format, not Null or less than 8 characters");
        }
        return password;
    }

    public User(Long id, String email){

        this.id = id;
        this.email = validateEmail(email);
    }

    protected void changePassword(String password) {
        this.password = validatePassword(password);
    }

    protected void changePhone(String phone) {
        this.phone = phone;
    }




}


