package com.roberteftene.codepath.codepath_api.service;

import com.roberteftene.codepath.codepath_api.domain.Lesson;
import com.roberteftene.codepath.codepath_api.dto.response.LessonsForTopicResponse;
import com.roberteftene.codepath.codepath_api.mapper.LessonMapper;
import com.roberteftene.codepath.codepath_api.repo.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;

    @Transactional(readOnly = true)
    public LessonsForTopicResponse getLessonsForTopic(String topic) {
        assert topic != null && !topic.isBlank() : "Topic must not be null or empty";

        List<Lesson> lessons = this.lessonRepository.findByTopicOrderByOrderIndex(topic);

        if (lessons.isEmpty()) {
            return LessonsForTopicResponse.builder()
                    .lessons(List.of())
                    .build();
        }

        return LessonsForTopicResponse.builder()
                .lessons(lessonMapper.toLessonsForTopicResponse(lessons))
                .build();
    }

}
