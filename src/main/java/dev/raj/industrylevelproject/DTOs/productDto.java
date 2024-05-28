package dev.raj.industrylevelproject.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // generates a toString method of the class.
public class productDto {

   private String title;
   private double price;
   private String description;
   private String category;
   private String image;

}
