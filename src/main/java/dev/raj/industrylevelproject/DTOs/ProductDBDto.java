package dev.raj.industrylevelproject.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDBDto {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private int isPublic;

}
