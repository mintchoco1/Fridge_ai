package com.fridge.backend.repository;

import com.fridge.backend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserIdOrderBySentAtDesc(Long userId);
    // 사용자의 알림을 최신순으로 조회

    List<Notification> findByUserIdAndIsReadFalse(Long userId);
    // 안 읽은 알림만 조회
}