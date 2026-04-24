package com.fridge.backend.repository;

import com.fridge.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 상속하면 기본 CRUD 메서드가 자동으로 생김
// <User, Long> = User 테이블을 다루고, PK 타입은 Long
public interface UserRepository extends JpaRepository<User, Long> {

    // findBy + 필드명 : JPA가 자동으로 쿼리를 만들어줌
    Optional<User> findByEmail(String email);
    // 이메일로 사용자 찾기 (로그인, 중복체크에 사용)

    boolean existsByEmail(String email);
    // 이메일이 이미 존재하는지 확인 (회원가입 중복체크)
}