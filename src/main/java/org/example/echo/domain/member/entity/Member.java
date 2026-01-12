package org.example.echo.domain.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.echo.global.auth.Role;



@Entity
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @Column(name = "member_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(message = "이메일 형식이 유효하지 않습니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    @Column(name = "member_email", nullable = false, unique = true)
    private String email;
//
//    @Column(nullable = false)
//    private boolean emailVerified = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String name;

    @Column(length = 255)
    private String password;

    @Builder
    public Member(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
