package dev.raj.industrylevelproject.Services;

import dev.raj.industrylevelproject.Models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //creates object of the class can find in actuator it is service so using @Service
public class CategoryServiceImple implements CategoryService{
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category getProductInCategory(int id) {
        return null;
    }
}
