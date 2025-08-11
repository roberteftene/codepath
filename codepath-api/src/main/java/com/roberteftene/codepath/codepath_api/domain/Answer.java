package com.roberteftene.codepath.codepath_api.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    
    @Column(name = "user_answer", nullable = false, columnDefinition = "TEXT")
    private String userAnswer;
    
    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;
    
    @Column(name = "attempt_number")
    private Integer attemptNumber;
    
    @Column(name = "time_spent_seconds")
    private Integer timeSpentSeconds;
    
    @Column(name = "points_earned")
    private Integer pointsEarned;
    
    @CreatedDate
    @Column(name = "answered_at", updatable = false)
    private LocalDateTime answeredAt;
}