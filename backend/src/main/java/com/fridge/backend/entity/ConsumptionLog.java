package com.fridge.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "consumption_logs")
@Getter @Setter
@NoArgsConstructor
public class ConsumptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String ingredientName;  // 재료명

    @Column(nullable = false, length = 50)
    private String category;        // 카테고리

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionType action;      // CONSUMED or EXPIRED

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    public enum ActionType {
        CONSUMED, EXPIRED
    }
}