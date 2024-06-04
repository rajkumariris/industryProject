package dev.raj.industrylevelproject.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }

}
