package com.roberteftene.codepath.codepath_api.domain;

import com.roberteftene.codepath.codepath_api.domain.enums.QuestionType;
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
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "code_snippet", columnDefinition = "TEXT")
    private String codeSnippet;
    
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
    
    @Column(name = "multiple_choice_options", columnDefinition = "TEXT")
    private String multipleChoiceOptions; // JSON array stored as string
    
    @Column(columnDefinition = "TEXT")
    private String explanation;
    
    @Column(name = "order_index")
    private Integer orderIndex;
    
    @Builder.Default
    @Column(name = "points")
    private Integer points = 5;
    
    @Builder.Default
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Answer> answers;
    
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}