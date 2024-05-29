package dev.raj.industrylevelproject.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
   private String Name;
   private String Description;
//   @OneToMany(mappedBy = "category")
//   private List<Product> products;
}
