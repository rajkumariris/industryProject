package dev.raj.industrylevelproject.Models;

import jakarta.persistence.CascadeType;
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
  @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)// should be on one to many side only and tells spring this already mapped at category in products table
  private List<Product> products;
}
