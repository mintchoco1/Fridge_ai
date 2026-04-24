package com.fridge.backend.repository;

import com.fridge.backend.entity.Ingredient;// Ingredient 엔티티를 다루는 리포지토리
import org.springframework.data.jpa.repository.JpaRepository;// JpaRepository를 상속하여 기본 CRUD 메서드 제공

import java.time.LocalDate;//날짜 타입
import java.util.List;// 리스트 타입

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByUserIdOrderByExpiryDateAsc(Long userId);
    // 해당 사용자의 재료를 유통기한순으로 조회

    List<Ingredient> findByUserIdAndExpiryDateBetween(
        Long userId, LocalDate start, LocalDate end
    );
    // 특정 기간 내 유통기한인 재료 조회 (알림용)

    List<Ingredient> findByUserIdAndStatus(
        Long userId, Ingredient.IngredientStatus status
    );
    // 상태별 재료 조회 (ACTIVE/CONSUMED/EXPIRED)
}