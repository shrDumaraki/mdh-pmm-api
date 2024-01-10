package org.mdh.pmm.references.mock.domain.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private String status;
}
