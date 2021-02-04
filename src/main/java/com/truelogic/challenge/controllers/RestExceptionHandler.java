package com.truelogic.challenge.controllers;

import com.truelogic.challenge.error.ChallengeApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.imageio.IIOException;

import static java.util.Optional.ofNullable;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IIOException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            IIOException ex) {
        ChallengeApiError apiError = new ChallengeApiError(HttpStatus.UNPROCESSABLE_ENTITY);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            Exception ex) {
        ChallengeApiError apiError = new ChallengeApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ofNullable(ex.getMessage()).orElse("Woops!! something was wrong.") );
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ChallengeApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
