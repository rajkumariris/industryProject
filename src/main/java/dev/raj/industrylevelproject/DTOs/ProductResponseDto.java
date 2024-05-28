package dev.raj.industrylevelproject.DTOs;

import dev.raj.industrylevelproject.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
   // this type returned value set to product variables in product object and return productreponsedto
   //bcoz first we converted dto to product model and the product model to dto becomes repeating
   // and controller has to return dto not model
   private Product product;
}
