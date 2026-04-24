package com.fridge.backend.repository;

import com.fridge.backend.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByUserIdOrderByCreatedAtDesc(Long userId);
    // 사용자의 레시피를 최신순으로 조회

    List<Recipe> findByUserIdAndIsBookmarkedTrue(Long userId);
    // 즐겨찾기한 레시피만 조회
}