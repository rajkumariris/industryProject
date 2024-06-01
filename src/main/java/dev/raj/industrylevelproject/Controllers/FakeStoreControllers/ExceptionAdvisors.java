package dev.raj.industrylevelproject.Controllers.FakeStoreControllers;


import dev.raj.industrylevelproject.DTOs.ErrorHanlderdto;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//2nd way of exceptional handling

@ControllerAdvice //this annotation is used to handle exceptions globally
public class ExceptionAdvisors {
    @ExceptionHandler(NotFoundException.class) // if any where notFoundException is thrown  in any  controller then this method will be called
    public ResponseEntity<ErrorHanlderdto> ErrorHandler(){
        ErrorHanlderdto errorHanlderdto = new ErrorHanlderdto();
        errorHanlderdto.setErrorMessage("Product not found");
        return new ResponseEntity(errorHanlderdto, HttpStatus.NOT_FOUND);
    }
}
