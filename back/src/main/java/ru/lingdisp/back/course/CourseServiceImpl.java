package ru.lingdisp.back.course;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    @Override
    public Course add(Course course) {
        return repository.save(course);
    }

    @Override
    public Course get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no a course with id " + id));
    }

    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
