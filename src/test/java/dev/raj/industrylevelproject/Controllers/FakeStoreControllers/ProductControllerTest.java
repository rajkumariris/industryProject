package dev.raj.industrylevelproject.Controllers.FakeStoreControllers;

import dev.raj.industrylevelproject.Controllers.DBControllers.ProductDBController;
import dev.raj.industrylevelproject.Exceptions.NotFoundException;
import dev.raj.industrylevelproject.Exceptions.ProductNotFoundException;
import dev.raj.industrylevelproject.Models.Product;
import dev.raj.industrylevelproject.Services.FakeStoreServices.ProductService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static  org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
@SpringBootTest //this helps to create all the objects of product controller no need to create object of product controller
class ProductControllerTest {
    @Autowired
    private ProductDBController productController;

    @MockBean // create mock productservice instead real productservice telling spring to do it

    private ProductService productService;
    @Test
    void TestAllproduct(){
        assert(1+1 ==2);
    }
    //test is nothing but a method
    // if the method is annotated with @Test then it is a test method
    // if the condtion fails then the test case fails



    // test name convention
    // test (what) and do what eg: test(Product)Gives(NewProdct)
    // telling what it does and what it return so it is more readable

    @Test
    void getAllProducts() throws NotFoundException {
        Product p1 = new Product();
        p1.setTitle("love"); // used mock dependency
        //when we call productservice getproducbyid we dont get real one but we get below code ouput which is title
      when(productService.getProductById(1L)).thenReturn(Optional.of(p1) ); // when tells whan to return as mock
      Optional<Product>  products = productController.getSingledbproduct(1L);
      //assert products.get().getTitle().equals("love");
        //it compare two values give much more cleaner format
     //   assertEquals("love",products.get().getTitle());

       // assertFalse(true); gives error bcoz it is saying if condition is false then it is correct


        //assertj library used below
        assertThat(products.get().getTitle())
                .isEqualTo("love")
                .isNotEqualTo("hate")
                .contains("love")
                .doesNotContain("hate");
    }




}