package ru.lingdisp.back.lesson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonServiceImpl implements LessonService {
    private final LessonRepository repository;

    @Override
    public Lesson add(Lesson lesson) {
        return repository.save(lesson);
    }

    @Override
    public Lesson get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no a lesson with id " + id));
    }

    @Override
    public List<Lesson> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Lesson> getAllByCourse(Long courseId) {
        return repository.findAllByCourse_Id(courseId);
    }

    @Override
    public Lesson update(Lesson lesson) {
        return repository.save(lesson);
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
