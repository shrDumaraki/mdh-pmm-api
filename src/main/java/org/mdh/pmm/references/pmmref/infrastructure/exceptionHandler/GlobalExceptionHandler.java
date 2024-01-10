package org.mdh.pmm.references.pmmref.infrastructure.exceptionHandler;

import org.mdh.pmm.references.pmmref.domain.exception.DataNotFoundException;
import org.mdh.pmm.references.pmmref.domain.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleDataNotFoundException(DataNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ServerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleServerException(ServerException ex) {
        return ex.getMessage();
    }
}
