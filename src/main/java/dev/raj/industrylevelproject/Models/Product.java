package dev.raj.industrylevelproject.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
     private double price;
     private String description; // cascade persist means if category table is not there but we trying to insert using product table then create category table along with it
     @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE) //lazy only products when we call categories then categories also
     private Category category;
     private String image;
}
