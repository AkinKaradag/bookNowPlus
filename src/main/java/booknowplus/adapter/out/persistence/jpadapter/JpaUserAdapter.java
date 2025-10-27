package booknowplus.adapter.out.persistence.jpadapter;

import booknowplus.adapter.out.persistence.entities.user.CompanyUserJpaEntity;
import booknowplus.adapter.out.persistence.entities.user.PrivateUserJpaEntity;
import booknowplus.adapter.out.persistence.entities.user.UserJpaEntity;
import booknowplus.adapter.out.persistence.repository.UserJpaRepository;
import booknowplus.application.User.port.out.UserRepository;
import booknowplus.domain.model.users.CompanyUser;
import booknowplus.domain.model.users.PrivateUser;
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
        if(user instanceof PrivateUser privateUser) {
            return mapPrivateUserToJpa(privateUser);
        } else if (user instanceof CompanyUser companyUser){
            return mapCompanyUserToJpa(companyUser);
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }

    public PrivateUserJpaEntity mapPrivateUserToJpa (PrivateUser user) {
        return PrivateUserJpaEntity.builder()

                .email(user.getEmail())
                .password(user.getPasswordHash())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .status(user.getStatus())
                .build();
    }

    public CompanyUserJpaEntity mapCompanyUserToJpa(CompanyUser user) {
        return CompanyUserJpaEntity.builder()

                .email(user.getEmail())
                .password(user.getPasswordHash())
                .companyName(user.getCompanyName())
                .street(user.getStreet())
                .number(user.getNumber())
                .postalCode(user.getPostalCode())
                .city(user.getCity())
                .phone(user.getPhone())
                .build();
    }

    private User mapToDomain(UserJpaEntity entity) {
        if (entity instanceof PrivateUserJpaEntity privateEntity) {
            return mapPrivateUserToDomain(privateEntity);
        } else if (entity instanceof CompanyUserJpaEntity companyEntity) {
            return mapCompanyUserToDomain(companyEntity);
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }
    }

    private PrivateUser mapPrivateUserToDomain (PrivateUserJpaEntity entity) {
        return PrivateUser.create(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhone()
        );
    }

    private CompanyUser mapCompanyUserToDomain(CompanyUserJpaEntity entity) {
        return CompanyUser.create(
                entity.getId(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCompanyName(),
                entity.getPhone(),
                entity.getStreet(),
                entity.getNumber(),
                entity.getPostalCode(),
                entity.getCity()
        );
    }

}


