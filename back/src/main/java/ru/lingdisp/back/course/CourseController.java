package ru.lingdisp.back.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Tag(name = "courses", description = "Controller for Courses")
@CrossOrigin("*")
public class CourseController {
    private final CourseService service;

    @PostMapping(produces = {"application/json"})
    @Operation(
            summary = "Creation Course",
            description = "Creation Course",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Creation Course",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Course.class)
                            )
                    })
    })
    public ResponseEntity<Course> add(@RequestBody @Valid Course course) {
        return ResponseEntity.ok(service.add(course));
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Getting Course by ID",
            description = "Getting Course by ID",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting Course by ID",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Course.class)
                            )
                    })
    })
    public ResponseEntity<Course> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping(produces = {"application/json"})
    @Operation(
            summary = "Getting all Courses",
            description = "Getting all Courses",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting all Courses",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Course.class))
                            )
                    })
    })
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping(produces = {"application/json"})
    @Operation(
            summary = "Updating Course",
            description = "Updating Course",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updating Course",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Course.class)
                            )
                    })
    })
    public ResponseEntity<Course> update(@RequestBody @Valid Course course) {
        return ResponseEntity.ok(service.update(course));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Deleting Course By ID",
            description = "Deleting Course By ID",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Course By ID"
            )
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping(produces = {"application/json"})
    @Operation(
            summary = "Deleting all Courses",
            description = "Deleting Courses",
            tags = {"courses"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Courses"
            )
    })
    public void delete() {
        service.deleteAll();
    }
}
