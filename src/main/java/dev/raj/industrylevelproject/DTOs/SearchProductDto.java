package dev.raj.industrylevelproject.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductDto {
    private String SearchTerm;
    private int NumberOfProducts;
    private int Offset;

}
