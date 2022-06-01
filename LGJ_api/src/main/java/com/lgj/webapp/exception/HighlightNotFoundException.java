package com.lgj.webapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HighlightNotFoundException extends RuntimeException {
    public HighlightNotFoundException(String message) {super(message);}
    
}
