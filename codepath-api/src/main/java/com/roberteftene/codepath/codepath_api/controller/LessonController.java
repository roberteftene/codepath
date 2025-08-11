package com.roberteftene.codepath.codepath_api.controller;

import com.roberteftene.codepath.codepath_api.dto.response.LessonsForTopicResponse;
import com.roberteftene.codepath.codepath_api.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/{topic}")
    public ResponseEntity<LessonsForTopicResponse> getLessons(@PathVariable String topic) {
        return ResponseEntity.ok(lessonService.getLessonsForTopic(topic));
    }

}
