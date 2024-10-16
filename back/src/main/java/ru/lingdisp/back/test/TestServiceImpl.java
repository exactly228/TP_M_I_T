package ru.lingdisp.back.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceImpl implements TestService {
    private final TestRepository repository;

    @Override
    public Test add(Test test) {
        return repository.save(test);
    }

    @Override
    public Test get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no a lesson with id " + id));
    }

    @Override
    public List<Test> getAll() {
        return repository.findAll();
    }

    @Override
    public Test update(Test test) {
        return repository.save(test);
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
