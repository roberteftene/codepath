package com.roberteftene.codepath.codepath_api.domain;

import com.roberteftene.codepath.codepath_api.domain.enums.DifficultyLevel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Lesson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String topic;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficulty;
    
    @Builder.Default
    @Column(name = "xp_reward")
    private Integer xpReward = 10;
    
    @Column(name = "estimated_minutes")
    private Integer estimatedMinutes;
    
    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @Column(name = "prerequisite_lesson_id")
    private Long prerequisiteLessonId;
    
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Question> questions;
    
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserProgress> userProgresses;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}