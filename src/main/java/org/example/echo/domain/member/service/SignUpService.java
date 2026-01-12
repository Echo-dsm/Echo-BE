package org.example.echo.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.example.echo.domain.member.entity.repository.MemberRepository;
import member.presentation.dto.request.MemberSignUpRequestDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

        public void signup(MemberSignUpRequestDTO data) { //회원가입 create
            memberRepository.findByEmail(data.email()).ifPresent(member -> {});


        }

}
