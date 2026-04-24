package com.fridge.backend.repository;

import com.fridge.backend.entity.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

// 대시보드에서 월별 통계 잴 때 사용
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {

    List<ConsumptionLog> findByUserIdAndLoggedAtBetween(
        Long userId, LocalDateTime start, LocalDateTime end
    );
    // 특정 기간의 소비 기록 조회 (월별 통계용)

    List<ConsumptionLog> findByUserIdAndAction(
        Long userId, ConsumptionLog.ActionType action
    );
    // 소비/폐기별 기록 조회
}