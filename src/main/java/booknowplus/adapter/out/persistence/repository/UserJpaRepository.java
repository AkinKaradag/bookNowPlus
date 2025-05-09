package booknowplus.adapter.out.persistence.repository;

import booknowplus.adapter.out.persistence.entities.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
}
