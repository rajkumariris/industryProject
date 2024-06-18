package dev.raj.industrylevelproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//sometimes other beeans in our folders could not be scanned so we use @ComponentScan with basePackages
//@ComponentScan({"dev.raj.industrylevelproject", "dev.raj.industrylevelproject.Configs"})
@SpringBootApplication
public class IndustrylevelprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndustrylevelprojectApplication.class, args);
    }

}
