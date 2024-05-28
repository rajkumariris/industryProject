package dev.raj.industrylevelproject.Controllers;


import dev.raj.industrylevelproject.Clients.FakeStoreproductDto;
import dev.raj.industrylevelproject.DTOs.FakeStoreCategoryDto;
import dev.raj.industrylevelproject.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products/categories")
public class CategoryController {

    CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping()
    public List<String> getAllCategories(){
        return  categoryService.getAllCategories();
    }

    @GetMapping("/{category_Name}")
    public List<FakeStoreproductDto>  getProductInCategory(@PathVariable("category_Name") String categoryName){
           List<FakeStoreproductDto> productlist =  categoryService.getProductInCategory(categoryName);
           return productlist;
    }
}
