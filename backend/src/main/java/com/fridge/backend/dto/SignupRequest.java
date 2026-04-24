package com.fridge.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {
    private String email;      // 회원가입할 이메일
    private String password;   // 비밀번호
    private String nickname;   // 닉네임
}