package ru.lingdisp.back.test;

import java.util.List;

public interface TestService {
    Test add(Test test);

    Test get(Long id);

    List<Test> getAll();

    Test update(Test test);

    void delete(Long id);

    void deleteAll();
}
