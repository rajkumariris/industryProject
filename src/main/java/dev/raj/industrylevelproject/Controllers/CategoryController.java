package dev.raj.industrylevelproject.Controllers;


import dev.raj.industrylevelproject.Services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping()
    public String getAllCategories(){
      return "All Categories";
    }

    @GetMapping("/{category_id}")
  public String getAllproductsInCategory(@PathVariable("category_id") Long categoryId){
      return "All Products in Category"+categoryId;
  }
}
