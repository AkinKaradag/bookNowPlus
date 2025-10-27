package booknowplus.application.User.port.in.PrivateUser;

import booknowplus.application.User.command.privateUser.CreatePrivateUserCommand;
import booknowplus.domain.model.users.PrivateUser;

public interface CreatePrivateUserUseCase {
    PrivateUser createPrivateUser(CreatePrivateUserCommand command);
}
