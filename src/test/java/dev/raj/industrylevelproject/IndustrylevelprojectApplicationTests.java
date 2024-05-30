package dev.raj.industrylevelproject;

import dev.raj.industrylevelproject.InheritanceExamples.SingleClass.*;
import dev.raj.industrylevelproject.Models.Category;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Repositories.CategoryRepository;
import dev.raj.industrylevelproject.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IndustrylevelprojectApplicationTests {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testAllInheritances(){

        Category category = new Category();
        category.setName("phones");
      // categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("apple");
        product.setPrice(1000);
        product.setCategory(category);
        productRepository.save(product);

    }

    @Test  // if @Transactional lazy loading gives error
    @Transactional // by defauly it is lazy loading so @Transactional says lazy loading happen in the same transaction
    void testProducttable(){
        //Eager fetching fetches categories along with products in a single call
        //lazy fetching fetches only products and when we call categories then only categories get fetched
        Product product =  productRepository.findProductById(1L);
        System.out.println("fetched products");
       Category category=  product.getCategory();
       System.out.println(category.getName());
    }

    @Test
    @Transactional
    void fetchType(){
      Product product =  productRepository.findProductById(3L);
      Category category= product.getCategory();
        System.out.println(category.getName());
    }

    @Test
    void eagerFetchType(){
       Product product= productRepository.findProductById(3L);

    }

    @Test
    void cascadeTypePersist(){
        // here we are saving without first saving category object directly at once saving
        // the category with product
        Category category = new Category();
        category.setName("beauty");
        Product product = new Product();
        product.setTitle("lipstick");
        product.setPrice(100);
        product.setCategory(category);
        productRepository.save(product);
    }
    @Test
    @Transactional
    void cascadeTypeDelete(){
         Long productId = 1L;
         productRepository.deleteById(productId);
         System.out.println("deleted product");
    }

    @Test
    @Transactional
    void allproduct(){
           Category category = categoryRepository.findCategoryById(1L);
           for(Product product: category.getProducts()){
               System.out.println(product.getPrice());
           }
    }

    @Test
    void allCategories(){
        List<Category> category = categoryRepository.findAllCategories(List.of(1L,2L));
        for(Category c : category){
            for(Product p : c.getProducts()){
                System.out.println(p.getPrice());
            }
        }
    }

}
