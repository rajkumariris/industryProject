package dev.raj.industrylevelproject.Repositories;

import dev.raj.industrylevelproject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category save(Category category);
    Category findCategoryById(Long id);

    List<Category> findAllCategories(List<Long> ids);
}
