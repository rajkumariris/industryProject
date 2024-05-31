package dev.raj.industrylevelproject.Repositories;

import dev.raj.industrylevelproject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDBRepository extends JpaRepository<Category, Long> {

    Category save(Category category);
}
