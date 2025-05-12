package booknowplus.adapter.out.persistence.entities.user;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "company_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CompanyUserJpaEntity extends UserJpaEntity{
    private String companyName;
    private String street;
    private String number;
    private String postalCode;
    private String city;
}
