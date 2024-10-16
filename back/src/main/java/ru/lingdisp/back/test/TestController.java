package ru.lingdisp.back.test;

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
@RequestMapping("/tests")
@RequiredArgsConstructor
@Tag(name = "tests", description = "Controller for Tests")
@CrossOrigin("*")
public class TestController {
    private final TestService service;

    @PostMapping(produces = {"application/json"})
    @Operation(
            summary = "Creation Test",
            description = "Creation Test",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Creation Test",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Test.class)
                            )
                    })
    })
    public ResponseEntity<Test> add(@RequestBody @Valid Test test) {
        return ResponseEntity.ok(service.add(test));
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Getting Test by ID",
            description = "Getting Test by ID",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting Test by ID",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Test.class)
                            )
                    })
    })
    public ResponseEntity<Test> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping(produces = {"application/json"})
    @Operation(
            summary = "Getting all Tests",
            description = "Getting all Tests",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting all Tests",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Test.class))
                            )
                    })
    })
    public ResponseEntity<List<Test>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping(produces = {"application/json"})
    @Operation(
            summary = "Updating Test",
            description = "Updating Test",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Updating Test",
                    content = {
                            @Content(
                                    mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Test.class)
                            )
                    })
    })
    public ResponseEntity<Test> update(@RequestBody @Valid Test test) {
        return ResponseEntity.ok(service.update(test));
    }

    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Deleting Test By ID",
            description = "Deleting Test By ID",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Test By ID"
            )
    })
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping(produces = {"application/json"})
    @Operation(
            summary = "Deleting all Tests",
            description = "Deleting Tests",
            tags = {"tests"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Deleting Tests"
            )
    })
    public void delete() {
        service.deleteAll();
    }
}
