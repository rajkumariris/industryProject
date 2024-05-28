package dev.raj.industrylevelproject.Controllers;

import dev.raj.industrylevelproject.Services.MyFirstService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller creates object of the class can find in actuator it is controller so using @Controller
//@Controller


// @Restcontrolller is also says http controller used to use http method and also creates object of the class
@RestController
public class Myfirstcontroller {

    //dependency injecttion spring first created service object(dependency) then controller object
    // given that service object to controller you can see it in actuator
    MyFirstService myFirstService;
    public Myfirstcontroller(MyFirstService myFirstService){
        this.myFirstService = myFirstService;
    }

    //when in chrome we call / u give me the below string hello world
    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

}
