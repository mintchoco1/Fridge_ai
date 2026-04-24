package com.fridge.backend.entity;

import jakarta.persistence.*;//JPA 관련 기능.@Entity,@Table,@Id,@GeneratedValue,@Column,@PrePersist 등
import lombok.Getter;
import lombok.NoArgsConstructor;//롬복 관련 기능.@Getter,@Setter,@NoArgsConstructor 등 기본 생성자 자동 생성
import lombok.Setter;

import java.time.LocalDateTime;//날짜,시간 객체 사용. DB의 DATETIME

@Entity//이 클래스는 db 테이블
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor//기본 생성자 자동 생성
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //pk 값을 db가 자동으로 증가시키도록 설정
    //우리가 id 값을 직접 넣지 않음
    //stragegy 는 어떤 방식으로 증가 시킬지
    //GenerationType.IDENTITY 는 db가 자동으로 증가시키는 방식. 1씩 증가.
    private Long id;                    // 블용자 ID (자동 증가)

    @Column(unique = true, nullable = false, length = 100)
    private String email;               // 이메일

    @Column(nullable = false, length = 255)
    private String password;            // 비밀번호 (BCrypt 암호화)

    @Column(nullable = false, length = 50)
    private String nickname;            // 닉네임

    @Column(length = 255)
    private String fcmToken;            // FCM 푸시 토큰

    @Column(columnDefinition = "INT DEFAULT 3")
    private Integer alarmDays = 3;      // 몇일 전 알림 (기본 3일)

    @Column(nullable = false)
    private LocalDateTime createdAt;    // 가입일

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();  // 저장 전 자동으로 현재시간 입력
    }
}