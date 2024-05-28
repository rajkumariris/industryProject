package dev.raj.industrylevelproject.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category extends BaseModel {
   private String Name;
   private String Description;
   private List<Product> products;
}
