package com.fridge.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
@Getter @Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String title;           // 레시피 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredients;     // 필요 재료 (JSON 형태로 저장)

    @Column(nullable = false, columnDefinition = "TEXT")
    private String instructions;    // 조리법

    private Integer cookingTime;    // 조리 시간 (분)

    @Column(nullable = false)
    private Boolean isBookmarked = false;   // 즐겨찾기

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}