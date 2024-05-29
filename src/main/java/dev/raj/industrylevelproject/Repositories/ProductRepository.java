package dev.raj.industrylevelproject.Repositories;

import dev.raj.industrylevelproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);
}
