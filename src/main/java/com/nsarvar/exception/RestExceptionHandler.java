package com.nsarvar.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by nsarvar on 12/26/17.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex, ex.getMessage());

        return buildResponseEntity(errorMessage);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorMessage errorMessage) {
        return new ResponseEntity<>(errorMessage, errorMessage.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ErrorMessage(HttpStatus.BAD_REQUEST, ex, error));
    }
}
