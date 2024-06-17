package dev.raj.industrylevelproject.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
   private String Name;
   private String Description;
  @OneToMany(mappedBy = "category",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)// should be on one to many side only and tells spring this already mapped at category in products table
  @Fetch(FetchMode.SELECT)
  @BatchSize(size = 1)// it will fetch 1 product1 at a time
  @JsonBackReference
  private List<Product> products;
}

//fetch mode : says how many queries we want to get like one query or join query or subselect query
//fetch type :  run at once all queries or run at when we call catagory
// select gives for each categorie gives each slect query
//join gives all the products in one query
//subselect gives all the products in one query and then all the categories in one query