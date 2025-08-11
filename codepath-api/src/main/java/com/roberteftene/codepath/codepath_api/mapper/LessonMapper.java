package com.roberteftene.codepath.codepath_api.mapper;

import com.roberteftene.codepath.codepath_api.domain.Lesson;
import com.roberteftene.codepath.codepath_api.dto.response.LessonDto;
import com.roberteftene.codepath.codepath_api.dto.response.LessonsForTopicResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonDto toDto(Lesson lesson);
    List<LessonDto> toLessonsForTopicResponse(List<Lesson> lessons);
}
