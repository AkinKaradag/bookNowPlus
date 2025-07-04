package booknowplus.application.User.service;

import booknowplus.application.User.command.privateUser.CreatePrivateUserCommand;
import booknowplus.application.User.common.UserIdGenerator;
import booknowplus.application.User.port.out.UserRepository;
import booknowplus.domain.model.users.PrivateUser;

public class CreatePrivateUserService {
    private final UserRepository userRepository;
    private final UserIdGenerator userIdGenerator;

    public CreatePrivateUserService(UserRepository userRepository, UserIdGenerator userIdGenerator) {
        this.userRepository = userRepository;
        this.userIdGenerator = userIdGenerator;
    }

    public PrivateUser createPrivateUser(CreatePrivateUserCommand command) {
        Long userId = userIdGenerator.generateId();
        PrivateUser privateUser = PrivateUser.create(
                userId,
                command.getEmail(),
                command.getPhone(),
                command.getPassword(),
                command.getFirstName(),
                command.getLastName()
        );
        userRepository.save(privateUser);
        return privateUser;
    }
}
