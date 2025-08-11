package com.roberteftene.codepath.codepath_api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record LessonsForTopicResponse(
        List<LessonDto> lessons
) {
}
