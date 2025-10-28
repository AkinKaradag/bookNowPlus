package booknowplus.adapter.in.web.dto.requests.privateUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePrivateUserRequest (
    @NotBlank
    String firstName,

    @NotBlank
    String lastName,

    @Email
    String email,

    @Size(min = 8)
    String password,

    String phone
) {}
