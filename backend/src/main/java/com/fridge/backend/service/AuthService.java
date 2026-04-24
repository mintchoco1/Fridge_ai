package com.fridge.backend.service;

import com.fridge.backend.dto.LoginRequest;
import com.fridge.backend.dto.SignupRequest;
import com.fridge.backend.entity.User;
import com.fridge.backend.repository.UserRepository;
import com.fridge.backend.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    public void signup(SignupRequest request) {

        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("이미 사용중인 이메일이에요!");
        }

        // User 객체 만들기
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 비밀번호 암호화
        user.setNickname(request.getNickname());

        // DB에 저장
        userRepository.save(user);
    }

    // 로그인
    public String login(LoginRequest request) {

        // 이메일로 사용자 찾기 (없으면 에러)
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 이메일이에요!"));

        // 비밀번호 확인
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸어요!");
        }

        // JWT 토큰 발급해서 반환
        return jwtTokenProvider.generateToken(user.getEmail());
    }
}