package org.mdh.pmm.references.mock.annotations;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.mdh.pmm.references.mock.domain.exception.ExceptionResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

import static org.mdh.pmm.references.mock.domain.exception.ExceptionResponseExamples.ERROR_RESPONSE_404;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
        responseCode = "404",
        description = "Data not found",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ExceptionResponse.class),
                examples = @ExampleObject(ERROR_RESPONSE_404)
        )
)
public @interface NotFoundResponse {
}