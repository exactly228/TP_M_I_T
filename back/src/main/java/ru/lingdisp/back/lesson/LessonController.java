package ru.lingdisp.back.lesson;

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
@RequestMapping("/lessons")
@RequiredArgsConstructor
@Tag(name = "lessons", description = "Controller for Lessons")
@CrossOrigin("*")
public class LessonController {
    private final LessonService service;

    @PostMapping(produces = {"application/json"})
    @Operation(
            summary = "Creation Lesson",
            description = "Creation Lesson",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Creation Lesson",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Lesson.class)
                            )
                    })
    })
    public ResponseEntity<Lesson> add(@RequestBody @Valid Lesson lesson) {
        return ResponseEntity.ok(service.add(lesson));
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Getting Lesson by ID",
            description = "Getting Lesson by ID",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting Lesson by ID",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Lesson.class)
                            )
                    })
    })
    public ResponseEntity<Lesson> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping(produces = {"application/json"})
    @Operation(
            summary = "Getting all Lessons",
            description = "Getting all Lessons",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting all Lessons",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Lesson.class))
                            )
                    })
    })
    public ResponseEntity<List<Lesson>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/course/{id}", produces = {"application/json"})
    @Operation(
            summary = "Getting all Lessons by Course ID",
            description = "Getting all Lessons by Course ID",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting all Lessons by Course ID",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Lesson.class))
                            )
                    })
    })
    public ResponseEntity<List<Lesson>> getAllByCourse(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAllByCourse(id));
    }

    @PutMapping(produces = {"application/json"})
    @Operation(
            summary = "Updating Lesson",
            description = "Updating Lesson",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updating Lesson",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Lesson.class)
                            )
                    })
    })
    public ResponseEntity<Lesson> update(@RequestBody @Valid Lesson lesson) {
        return ResponseEntity.ok(service.update(lesson));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Deleting Lesson By ID",
            description = "Deleting Lesson By ID",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Lesson By ID"
            )
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping(produces = {"application/json"})
    @Operation(
            summary = "Deleting all Lessons",
            description = "Deleting Lessons",
            tags = {"lessons"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Lessons"
            )
    })
    public void delete() {
        service.deleteAll();
    }
}
