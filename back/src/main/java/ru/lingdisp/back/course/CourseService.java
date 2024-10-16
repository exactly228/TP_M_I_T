package ru.lingdisp.back.course;

import java.util.List;

public interface CourseService {
    Course add(Course course);

    Course get(Long id);

    List<Course> getAll();

    Course update(Course course);

    void delete(Long id);

    void deleteAll();
}
