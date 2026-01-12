package member.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import member.presentation.dto.request.MemberSignUpRequestDTO;
import org.example.echo.domain.member.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@RequestBody @Valid MemberSignUpRequestDTO data) {
        signUpService.signup(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
