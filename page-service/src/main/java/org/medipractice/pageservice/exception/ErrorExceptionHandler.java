package org.medipractice.pageservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.transaction.NotSupportedException;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@Slf4j
@ControllerAdvice
public class ErrorExceptionHandler {

    // 400
    @ExceptionHandler({DataIntegrityViolationException.class,  ConstraintViolationException.class, NotSupportedException.class})
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
        throw new BadRequestException(ex);
    }


    // 404
    @ExceptionHandler(value = {IOException.class, EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        throw new ResourceNotFoundException(ex);
    }

    // 409
    @ExceptionHandler({OptimisticLockingFailureException.class})
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        throw new ConflictException(ex);
    }

    // 500
    @ExceptionHandler({InternalError.class, NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class, HttpServerErrorException.class})
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        throw new InternalServerError(ex);
    }

}
