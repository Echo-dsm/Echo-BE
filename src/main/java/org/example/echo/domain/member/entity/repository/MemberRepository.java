package org.example.echo.domain.member.entity.repository;

import org.example.echo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Long> findByUserId(Long userId);

    Optional<Member> findByUsername(String username);

    Optional<Member> findIdByUsername(String username);

    Optional<Member> findByEmail(String email);

}