package booknowplus.domain.model.users;

import booknowplus.domain.model.enm.CreateStatus;
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

    public CompanyUser(Long id, String email, String passwordHash, String companyName, String street, String number, String postalCode, String city) {
        super(id, email, passwordHash);

        this.companyName = validateRequired(companyName, "companyName");
        this.street = validateRequired(street, "street");
        this.number = validateRequired(number, "number");
        this.postalCode = validateRequired(postalCode, "postalCode");
        this.city = validateRequired(city, "city");
        this.status = CreateStatus.PENDING;
    }

    public static CompanyUser create(Long id, String email, String companyName, String passwordHash, String phone, String street, String number, String postalCode, String city) {
        CompanyUser user = new CompanyUser(id, email, passwordHash, companyName, street, number, postalCode, city);
        user.changePassword(passwordHash);
        user.changePhone(phone);
        return user;
    }

    public void changeCompanyName(String companyName) {
        this.companyName = validateRequired(companyName, "companyName");
    }

    public void changeAddress(String street, String number, String postalCode, String city) {
        this.street = validateRequired(street, "street");
        this.number = validateRequired(number, "number");
        this.postalCode = validateRequired(postalCode, "postalCode");
        this.city = validateRequired(city, "city");
    }

}
