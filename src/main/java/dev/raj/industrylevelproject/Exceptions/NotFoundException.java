package dev.raj.industrylevelproject.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//3rd way of exception handling
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason=" somehting not found ") // this annotation is used to send the status code to the client (404
public class NotFoundException extends  Exception{

    public NotFoundException(String message){
        super(message);
    }
}
