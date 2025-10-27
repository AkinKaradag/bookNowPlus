package booknowplus.application.User.service;

import booknowplus.application.User.command.privateUser.CreatePrivateUserCommand;
import booknowplus.application.User.port.in.PrivateUser.CreatePrivateUserUseCase;
import booknowplus.application.User.port.out.PasswordEncoderPort;
import booknowplus.application.User.port.out.UserRepository;
import booknowplus.domain.model.users.PrivateUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreatePrivateUserService implements CreatePrivateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoderPort passwordEncoder;

    public CreatePrivateUserService(UserRepository userRepository, PasswordEncoderPort passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public PrivateUser createPrivateUser(CreatePrivateUserCommand command) {
        String hash = passwordEncoder.encode(command.getPassword());
        PrivateUser privateUser = PrivateUser.create(
                command.getId(),
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
