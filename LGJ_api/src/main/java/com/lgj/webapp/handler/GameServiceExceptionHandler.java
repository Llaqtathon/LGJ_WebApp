package com.lgj.webapp.handler;

import com.lgj.webapp.exception.GameNotFoundException;
import com.lgj.webapp.exception.GameServiceExceptionResponse;
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
public class GameServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        GameServiceExceptionResponse response = new GameServiceExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(GameNotFoundException exception, WebRequest request) {
        GameServiceExceptionResponse response = new GameServiceExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}