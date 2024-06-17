package dev.raj.industrylevelproject.Repositories.FakeStoreRepositories;

import dev.raj.industrylevelproject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category save(Category category);
    Category findCategoryById(Long id);
    List<Category> findAllByIdIn(List<Long> ids);
}
