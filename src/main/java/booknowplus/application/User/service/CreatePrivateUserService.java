package booknowplus.application.User.service;

import booknowplus.application.User.command.privateUser.CreatePrivateUserCommand;
import booknowplus.application.User.common.UserIdGenerator;
import booknowplus.application.User.port.out.PasswordEncoderPort;
import booknowplus.application.User.port.out.UserRepository;
import booknowplus.domain.model.users.PrivateUser;
import org.springframework.transaction.annotation.Transactional;

public class CreatePrivateUserService {
    private final UserRepository userRepository;
    private final UserIdGenerator userIdGenerator;
    private final PasswordEncoderPort passwordEncoder;

    public CreatePrivateUserService(UserRepository userRepository, UserIdGenerator userIdGenerator, PasswordEncoderPort passwordEncoder) {
        this.userRepository = userRepository;
        this.userIdGenerator = userIdGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public PrivateUser createPrivateUser(CreatePrivateUserCommand command) {
        Long userId = userIdGenerator.generateId();
        String hash = passwordEncoder.encode(command.getPassword());
        PrivateUser privateUser = PrivateUser.create(
                userId,
                command.getEmail(),
                hash,
                command.getFirstName(),
                command.getLastName(),
                command.getPhone()
        );
        userRepository.save(privateUser);
        return privateUser;
    }
}
