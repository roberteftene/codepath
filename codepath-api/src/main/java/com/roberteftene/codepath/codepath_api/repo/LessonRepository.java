package com.roberteftene.codepath.codepath_api.repo;

import com.roberteftene.codepath.codepath_api.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTopicOrderByOrderIndex(String topic);
}

