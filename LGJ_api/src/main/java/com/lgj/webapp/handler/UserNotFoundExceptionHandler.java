package com.lgj.webapp.handler;

import com.lgj.webapp.exception.EditionNotFoundException;
import com.lgj.webapp.exception.ExceptionResponse;
import com.lgj.webapp.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class UserNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    //TODO: Move to Edition handler
    @ExceptionHandler(EditionNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(EditionNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}