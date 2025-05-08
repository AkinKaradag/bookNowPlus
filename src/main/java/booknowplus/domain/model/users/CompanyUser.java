package booknowplus.domain.model.users;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class CompanyUser extends User {
    private String companyName;
    private String street;
    private String number;
    private String postalCode;
    private String city;

    private String validateRequired(String value, String fieldName) {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException((fieldName + " is required"));
        }
        return value;
    }

    public CompanyUser(Long id, String email, String companyName, String street, String number, String postalCode, String city) {
        super(id, email);

        this.companyName = validateRequired(companyName, "companyName");
        this.street = validateRequired(street, "street");
        this.number = validateRequired(number, "number");
        this.postalCode = validateRequired(postalCode, "postalCode");
        this.city = validateRequired(city, "city");
    }
}
