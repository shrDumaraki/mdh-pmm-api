package org.mdh.pmm.references.mock.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mdh.pmm.references.mock.annotations.InternalServerResponse;
import org.mdh.pmm.references.mock.annotations.NotFoundResponse;
import org.mdh.pmm.references.mock.controller.schema.ReferenceDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.mdh.pmm.references.constants.Paths.BASE_PATH;
import static org.mdh.pmm.references.constants.Paths.REFERENCE_DATA_PATH;
import static org.mdh.pmm.references.mock.domain.constant.ExampleObjects.REFERENCE_DROPDOWN_GENDER;
import static org.mdh.pmm.references.mock.domain.constant.ExampleObjects.REFERENCE_DROPDOWN_NAMEPREFIX;

@Tag(name = "Mock Response Data API", description = "An example API definition for Reference Data API")
@RestController
@RequestMapping("/mock")
public class ReferenceDataMockController {

    @GetMapping(REFERENCE_DATA_PATH)
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ReferenceDataResponse.class),
                    examples = {
                            @ExampleObject(name = "Gender", value = REFERENCE_DROPDOWN_GENDER),
                            @ExampleObject(name = "NamePrefix", value = REFERENCE_DROPDOWN_NAMEPREFIX)
                    }
            )
    )
    @InternalServerResponse
    @NotFoundResponse
    public ResponseEntity<ReferenceDataResponse> getDropdownData(@RequestParam String category) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
