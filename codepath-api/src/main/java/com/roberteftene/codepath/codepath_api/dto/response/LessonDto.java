package com.roberteftene.codepath.codepath_api.dto.response;


import com.roberteftene.codepath.codepath_api.domain.enums.DifficultyLevel;

public record LessonDto(
        Long id,
        String title,
        String topic,
        String description,
        Integer orderIndex,
        DifficultyLevel difficulty,
        Integer xpReward,
        Integer estimatedMinutes,
        Boolean isActive,
        Long prerequisiteLessonId
) {
}
