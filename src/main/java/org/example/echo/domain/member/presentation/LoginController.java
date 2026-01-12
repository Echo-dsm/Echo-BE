package org.example.echo.domain.member.presentation;

import lombok.RequiredArgsConstructor;
import org.example.echo.global.auth.CustomUserDetails;
import org.example.echo.global.jwt.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
//
//        UsernamePasswordAuthenticationToken authToken =
//                new UsernamePasswordAuthenticationToken(
//                        request.getUsername(),
//                        request.getPassword()
//                );
//
//        Authentication authentication =
//                authenticationManager.authenticate(authToken);
//
//        CustomUserDetails userDetails =
//                (CustomUserDetails) authentication.getPrincipal();
//
//        String accessToken =
//                jwtProvider.generateAccessToken(
//                        userDetails.getUsername()
//                );
//
//        return ResponseEntity.ok(
//                Map.of("accessToken", accessToken)
//        );
//    }
}
