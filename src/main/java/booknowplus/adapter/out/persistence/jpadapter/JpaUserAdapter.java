package booknowplus.adapter.out.persistence.jpadapter;

import booknowplus.adapter.out.persistence.entities.UserJpaEntity;
import booknowplus.adapter.out.persistence.repository.UserJpaRepository;
import booknowplus.application.User.port.out.UserRepository;
import booknowplus.domain.model.users.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaUserAdapter implements UserRepository {
    private final UserJpaRepository jpaRepo;

    @Override
    public void save(User user) {jpaRepo.save(mapToJpaEntity(user));}

    private UserJpaEntity mapToJpaEntity(User user) {
        return UserJpaEntity.builder()
                .id(user.getId())
                .build();
    }
}
