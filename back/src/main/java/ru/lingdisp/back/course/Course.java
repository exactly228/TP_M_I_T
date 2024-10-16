package ru.lingdisp.back.course;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
@Schema(name = "Course", description = "Model for Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty
    @Size(max = 100, min = 1)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    @Size(max = 100)
    private String author;

    @Column(name = "banner_url")
    private String bannerUrl;
}
