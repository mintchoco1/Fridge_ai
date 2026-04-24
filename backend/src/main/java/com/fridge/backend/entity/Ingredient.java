package com.fridge.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ingredients")
@Getter @Setter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    //ingredient는 user 객체를 가지고있음
    private User user;              // 어떤 사용자의 재료인지

    @Column(nullable = false, length = 100)
    private String name;            // 재료명

    @Column(nullable = false, length = 50)
    private String category;        // 카테고리 (육류/채소 등)

    @Column(length = 50)
    private String quantity;        // 수량

    @Column(nullable = false)
    private LocalDate expiryDate;   // 유통기한

    @Column(length = 500)
    private String imageUrl;        // 사진 URL

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IngredientStatus status = IngredientStatus.ACTIVE;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // 재료 상태 (활성/소비됨/만료됨)
    public enum IngredientStatus {
        ACTIVE, CONSUMED, EXPIRED
    }
}