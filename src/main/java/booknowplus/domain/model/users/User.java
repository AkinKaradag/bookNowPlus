package booknowplus.domain.model.users;

import booknowplus.domain.model.enm.CreateStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode
@ToString
public abstract class User {

    protected final Long id;
    protected final String email;
    protected String password;
    protected String phone;
    protected CreateStatus status;

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

    public void approve() {
        if (status != CreateStatus.PENDING) {
            throw new IllegalStateException("Cannot approve this company user");
        }
        this.status = CreateStatus.APPROVED;
    }

    public void reject() {
        if (status != CreateStatus.PENDING) {
            throw new IllegalStateException("Cannot reject this company user");
        }
        this.status = CreateStatus.REJECTED;
    }

    public void active() {
        if (status != CreateStatus.APPROVED) {
            throw new IllegalStateException("Cannot active this company user");
        }
        this.status = CreateStatus.ACTIVE;
    }

    public void inactive() {
        if (status != CreateStatus.ACTIVE) {
            throw new IllegalStateException("Cannot inactive this company user");
        }
        this.status = CreateStatus.INACTIVE;
    }

    public void block() {
        if (status != CreateStatus.ACTIVE && status != CreateStatus.INACTIVE) {
            throw new IllegalStateException("Cannot block this company user");
        }
        this.status = CreateStatus.BLOCKED;
    }

    public void cancel() {
        if (status != CreateStatus.ACTIVE) {
            throw new IllegalStateException("Cannot cancel this company user");
        }
        this.status = CreateStatus.CANCELLED;
    }

    public void delete() {
        if (status != CreateStatus.CANCELLED) {
            throw new IllegalStateException("Cannot delete this company user");
        }
        this.status = CreateStatus.DELETED;
    }

}


