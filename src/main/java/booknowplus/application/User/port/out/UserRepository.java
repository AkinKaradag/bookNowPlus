package booknowplus.application.User.port.out;

import booknowplus.domain.model.users.User;

public interface UserRepository {
    void save(User user);

}
