package dev.raj.industrylevelproject.Repositories;

import dev.raj.industrylevelproject.DTOs.ProductDBDto;
import dev.raj.industrylevelproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDBRepository extends JpaRepository<Product, Long>{

    Product save(Product product);


    //Category_Name is a field in the Category class
    //trying to fetch using subclass fields
    //Product findProductByCategory_NameAndCategory_Id(String name, Long id);


    //jpa methods should only return product model which is mentioned at top jpaRepositou<product,Long>
    // but with custom query  we can return our own type(productDBDto) jackson matches with the
    // title of row with title of productDBDto


    Product  findProductById(Long id);


    void deleteProductById(Long id);

    //check queires interface here we used Queries.IVVU_PRODUCTS this is varaible value is in queries interface
    @Query(value = Queries.IVVU_PRODUCTS, nativeQuery = true)
    ProductDBDto IvvuProduct(Long id);


    //JPA queries this query based on model we write Product is a model variable name should
    // match names in models
    //Java + SQL
    @Query("select p from Product p where p.id = :id and p.category.Name = :title")
    public List<Product> getByIdAndTitle(Long id, String title);


}
