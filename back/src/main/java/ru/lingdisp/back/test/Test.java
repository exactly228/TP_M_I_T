package ru.lingdisp.back.test;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import ru.lingdisp.back.lesson.Lesson;

@Entity
@Table(name = "tests")
@Data
@Schema(name = "Test", description = "Model for Tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    @Column(name = "question_1")
    private String question1;

    @Column(name = "right_answer_1")
    private String answer1;

    @Column(name = "question_2")
    private String question2;

    @Column(name = "right_answer_2")
    private String answer2;

    @Column(name = "question_3")
    private String question3;

    @Column(name = "right_answer_3")
    private String answer3;
}
