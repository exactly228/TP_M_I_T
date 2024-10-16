package ru.lingdisp.back.lesson;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.lingdisp.back.course.Course;

@Entity
@Table(name = "lessons")
@Data
@Schema(name = "Lesson", description = "Model for Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @Size(max = 100, min = 1)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "text")
    @Size(max = 1000)
    private String text;
}
