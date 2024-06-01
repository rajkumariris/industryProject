package dev.raj.industrylevelproject.Controllers.DBControllers.ExceptionAdvisors;

import dev.raj.industrylevelproject.DTOs.ErrorHanlderdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundException extends Exception{
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorHanlderdto> ProductNotfound(){
        ErrorHanlderdto errorHanlderdto = new ErrorHanlderdto();
        errorHanlderdto.setErrorMessage("Product evadu isthadu ra");
        return new ResponseEntity(errorHanlderdto, HttpStatus.NOT_FOUND);
    }
}
