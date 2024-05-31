package dev.raj.industrylevelproject.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
  @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)// should be on one to many side only and tells spring this already mapped at category in products table
  @Fetch(FetchMode.SUBSELECT)// select gives for each categorie gives each slect query
  //join gives all the products in one query
  //subselect gives all the products in one query and then all the categories in one query
  @BatchSize(size = 1)// it will fetch 1 product1 at a time
  private List<Product> products;
}

//fetch mode : says how many queries we want to get
//fetch type :  run at once all queries or run at when we call catagory
