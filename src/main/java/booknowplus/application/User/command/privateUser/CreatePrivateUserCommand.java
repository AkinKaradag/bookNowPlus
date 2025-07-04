package booknowplus.application.User.command.privateUser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePrivateUserCommand {
    private final Long id;
    private final String email;
    private final String password;
    private final String phone;
    private final String firstName;
    private final String lastName;
}
