package dev.raj.industrylevelproject.Repositories;

import dev.raj.industrylevelproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//how to write jpa method my trick if we want something from table
    // write table name or column write column name and it suggests
    Product save(Product product);

    Product findProductById(Long id);

   // Product findProductByIdIs(Long id);

    Product findByPriceBetweenAndTitleLessThanEqual(double min, double max, String lessThan);

    Product findByPriceLessThan(double price);

    Product findByImageIsNull();
    //productrepository.findByImageIsNull();//call
    // select * from product where image is null; // query

    //List<Product> findByTitleLikeIgnoreCaseStartingWith(String title);
     // both methods are same
    // select * from product where title like 'title%'; // query

    //List<Product> findByTitleLikeIgnoreCase(String title);
    // select * from product where title like '%title%'; // query

    //List<Product> findAllByPublicIs(boolean isPublic);
    void deleteById(Long id);

}
