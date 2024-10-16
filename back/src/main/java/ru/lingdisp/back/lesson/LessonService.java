package ru.lingdisp.back.lesson;

import java.util.List;

public interface LessonService {
    Lesson add(Lesson lesson);

    Lesson get(Long id);

    List<Lesson> getAll();

    List<Lesson> getAllByCourse(Long courseId);

    Lesson update(Lesson lesson);

    void delete(Long id);

    void deleteAll();
}
