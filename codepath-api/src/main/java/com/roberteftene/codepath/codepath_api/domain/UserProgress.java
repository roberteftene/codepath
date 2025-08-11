package com.roberteftene.codepath.codepath_api.domain;

import com.roberteftene.codepath.codepath_api.domain.enums.ProgressStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserProgress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgressStatus status;
    
    @Builder.Default
    @Column(name = "completion_percentage")
    private Double completionPercentage = 0.0;
    
    @Builder.Default
    @Column(name = "score")
    private Double score = 0.0;
    
    @Builder.Default
    @Column(name = "questions_answered")
    private Integer questionsAnswered = 0;
    
    @Builder.Default
    @Column(name = "correct_answers")
    private Integer correctAnswers = 0;
    
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;
    
    @Column(name = "time_spent_minutes")
    private Integer timeSpentMinutes;
    
    @Column(name = "xp_earned")
    private Integer xpEarned;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}