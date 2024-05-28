package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getProductInCategory(int id);

}
