package com.fridge.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
    private String email;     // 로그인할 이메일
    private String password;  // 비밀번호
}