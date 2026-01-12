package member.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.example.echo.global.auth.Role;

public record MemberSignUpRequestDTO(
        Role role,
        String name,
        String email,
        @NotBlank
        String password
) {
}
